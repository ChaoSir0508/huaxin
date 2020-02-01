package com.chao.huaxin.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.chao.huaxin.pojo.*;
import com.chao.huaxin.service.AccountsService;
import com.chao.huaxin.service.SitesService;
import com.chao.huaxin.service.TimesService;
import com.chao.huaxin.service.UserService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private SitesService sitesService;

    @Autowired
    private UserService userService;

    @Autowired
    private TimesService timesService;

    @Autowired
    private AccountsService accountsService;

    /**
     * 管理员登录
     *
     * @param name
     * @param password
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/login")
    public PageMessage login(String name, String password, HttpSession session) {
        PageMessage pageMessage = new PageMessage();

        if ("".equals(name) || "".equals(password)) {
            pageMessage.setStatus(0);
            return pageMessage;
        }
        if (!name.equals("huaxin") || !password.equals("huaxin")) {
            pageMessage.setStatus(0);
            return pageMessage;
        }
        pageMessage.setStatus(1);
        session.setAttribute("user", "chaosir");
        return pageMessage;
    }


    /**
     * 获得所以用户信息（包括标记被删除）
     *
     * @param model
     * @return
     */
    @GetMapping("/getUsers")
    public String listUser(Model model) {
        List<User> users = userService.listUser();
        model.addAttribute("users", users);
        model.addAttribute("count", users.size());
        return "admin/list";
    }

    /**
     * 跳转并带数据到修改页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("editUser")
    public String editUser(Integer id, Model model) {
        List<Times> times = timesService.getTimes();
        List<Sites> sites = sitesService.getSites();
        model.addAttribute("sites", sites);
        model.addAttribute("times", times);
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/edit";
    }

    /**
     * 修改用户的信息
     *
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping("editUser")
    public PageMessage editUser(User user) {
        PageMessage pageMessage = new PageMessage();
        try {
            userService.editUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            pageMessage.setStatus(0);
            return pageMessage;
        }
        pageMessage.setStatus(1);
        return pageMessage;
    }

    /***
     * 录入转账单号
     * @param accounts
     * @return
     */
    @ResponseBody
    @PostMapping("addAccount")
    public PageMessage addAccount(String accounts) {
        PageMessage pageMessage = new PageMessage();
        String[] account = accounts.split("\n");
        int c = 0;//计数器
        try {
            for (String s : account) {
                if (s.length() != 32) {
                    pageMessage.setStatus(0);
                    return pageMessage;
                }
                Integer exits = userService.updateStatus(s);
                //说明单号有对应的用户
                if (exits == 1) {
                    c += exits;
                    User userByAccount = userService.getUserByAccount(s);//返回该单号对应的用户信息
                    Accounts accountByAccount = accountsService.getAccountByAccount(s);
                    if (accountByAccount != null) {//二次激活，则更新
                        if (accountByAccount.getUser().equals("无")) {
                            accountByAccount.setAccount(s);
                            accountByAccount.setUser(userByAccount.getName());
                            accountsService.updateAccount(accountByAccount);
                        }
                    } else {//首次激活，则添加
                        //向单号表添加当前单号，用户名，状态为使用
                        Accounts accountPojo = new Accounts(s, userByAccount.getName());
                        accountsService.saveAccount(accountPojo);
                    }
                } else {//说明没有对应的用户
                    //向单号表添加单号，用户名无，状态未使用
                    Accounts accountByAccount = accountsService.getAccountByAccount(s);
                    if (accountByAccount != null) {//二次激活，则更新
                        continue;
                    } else {
                        Accounts accountPojo = new Accounts(s, "无");
                        accountsService.saveAccount(accountPojo);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            pageMessage.setStatus(0);
            pageMessage.setMessage("录入失败！请稍后尝试");
            return pageMessage;
        }
        pageMessage.setStatus(1);
        pageMessage.setMessage(c + "");
        return pageMessage;
    }

    /**
     * 录入地点
     *
     * @param sites
     * @return
     */
    @ResponseBody
    @PostMapping("/addSite")
    public PageMessage addSite(String sites) {
        PageMessage pageMessage = new PageMessage();
        try {
            String[] strings = sites.split("\n");
            for (String string : strings) {
                sitesService.saveSites(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
            pageMessage.setStatus(0);
            return pageMessage;
        }
        pageMessage.setStatus(1);
        return pageMessage;
    }

    /**
     * 地点修改
     *
     * @param id
     * @param status
     * @return
     */
    @GetMapping("/editSite")
    public String editSite(Integer id, String status) {
        if (status.equals("enabled")) {
            sitesService.enabledSite(id);
        } else if (status.equals("disabled")) {
            sitesService.disabledSite(id);
        } else if (status.equals("del")) {
            sitesService.deleteSite(id);
        }
        return "redirect:/admin/sites";
    }

    /**
     * 查询所有的地点，跳转指定位置
     *
     * @param model
     * @return
     */
    @RequestMapping("/sites")
    public String sites(Model model) {
        List<Sites> sitesAll = sitesService.getSitesAll();
        model.addAttribute("sites", sitesAll);
        return "admin/sites";
    }

    /**
     * 录入时间
     *
     * @param time
     * @return
     */
    @ResponseBody
    @PostMapping("/addTime")
    public PageMessage addTime(String time) {
        PageMessage pageMessage = new PageMessage();
        try {
            String[] split = time.split("\n");
            for (String s : split) {
                timesService.saveTimes(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
            pageMessage.setStatus(0);
            return pageMessage;
        }
        pageMessage.setStatus(1);
        return pageMessage;
    }

    /**
     * 查询所有的时间，跳转到指定页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/times")
    public String times(Model model) {
        List<Times> times = timesService.getTimesAll();
        model.addAttribute("times", times);
        return "admin/times";
    }

    /**
     * 时间修改
     *
     * @param id
     * @param status
     * @return
     */
    @GetMapping("/editTime")
    public String editTime(Integer id, String status) {
        if (status.equals("enabled")) {
            timesService.enabledTimes(id);
        } else if (status.equals("disabled")) {
            timesService.disabledTimes(id);
        } else if (status.equals("del")) {
            timesService.deleteTimes(id);
        }
        return "redirect:/admin/times";
    }

    /**
     * 查询所有单号，跳转到指定页面
     *
     * @return
     */
    @GetMapping("/accounts")
    public String accounts(Model model) {
        List<Accounts> accounts = accountsService.getAccounts();
        int count = accountsService.getAccountsCount().size();
        model.addAttribute("accounts", accounts);
        model.addAttribute("count", count);
        return "admin/accounts";

    }

}
