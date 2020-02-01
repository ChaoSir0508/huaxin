package com.chao.huaxin.controller;

import com.chao.huaxin.pojo.PageMessage;
import com.chao.huaxin.pojo.Sites;
import com.chao.huaxin.pojo.Times;
import com.chao.huaxin.pojo.User;
import com.chao.huaxin.service.SitesService;
import com.chao.huaxin.service.TimesService;
import com.chao.huaxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SitesService sitesService;

    @Autowired
    private TimesService timesService;

    @GetMapping("/")
    public String addUser(Model model) {
        List<Times> times = timesService.getTimes();
        List<Sites> sites = sitesService.getSites();
        model.addAttribute("sites", sites);
        model.addAttribute("times", times);
        return "add";
    }

    @GetMapping("/list")
    public String listUser(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("count", users.size());
        return "list";
    }

    @ResponseBody
    @PostMapping("/save")
    public PageMessage saveUser(User user) {
        PageMessage pageMessage = new PageMessage();
        String account = user.getAccount();
        User exist = userService.checkAccount(account);
        if (exist != null) {
            //存在写回json
            pageMessage.setStatus(0);
            return pageMessage;
        }
        //不存在
        Integer userExist = userService.saveUser(user);
        pageMessage.setStatus(1);
        return pageMessage;
    }

    @GetMapping("/update")
    public String updateUser(String account, Model model) {
        List<Times> times = timesService.getTimes();
        List<Sites> sites = sitesService.getSites();
        model.addAttribute("sites", sites);
        model.addAttribute("times", times);
        User user = userService.getUserByAccount(account);
        if (user == null) {
            model.addAttribute("error","该转账单号不存在！");
            return "/add";
        }
        model.addAttribute("user", user);
        return "edit";
    }

    @ResponseBody
    @PostMapping("/update")
    public PageMessage update(User user) {
        PageMessage pageMessage = new PageMessage();
        Integer integer = userService.updateUser(user);
        pageMessage.setStatus(1);
        return pageMessage;
    }

}
