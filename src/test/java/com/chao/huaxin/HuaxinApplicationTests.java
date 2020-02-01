package com.chao.huaxin;

import com.chao.huaxin.dao.AccountsMapper;
import com.chao.huaxin.dao.UserMapper;
import com.chao.huaxin.pojo.Accounts;
import com.chao.huaxin.pojo.User;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HuaxinApplicationTests {

   /* @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountsMapper accountsMapper;

    @Test
    void saveUser() {
        User user = new User("王超", "六路口", "18613725744", "12345678995455");
        userMapper.saveUser(user);
    }

    @Test
    void getUsers() {
        List<User> users = userMapper.getUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    @Test
    void getUser() {
        User user = userMapper.gerUserById(9);
        System.out.println(user);
    }

    @Test
    void updateUser() {
        User user = userMapper.gerUserById(9);
        user.setName("刘朝霞");
        user.setSite("刘家屯");
        user.setTelephone("1544");
        userMapper.updateUser(user);
    }

*//*    @Test
    void delUser() {
        userMapper.deleteUser(9);
    }*//*

    @Test
    void getAccount() {
        User user1 = userMapper.getAccount("aa");
        System.out.println(user1);
        User user2 = userMapper.getAccount("1234567899545");
        System.out.println(user2);
    }

    @Test
    void setStatus() {
        Integer integer = userMapper.setStatus("129545");
        System.out.println(integer);
    }

    @Test
    void getAccountByAccount() {
        Accounts accountByAccount = accountsMapper.getAccountByAccount("12312321123");
        System.out.println(accountByAccount);
    }

    @Test
    void saveAccount() {
        Accounts accounts = new Accounts("12312321123");
        Integer integer = accountsMapper.saveAccount(accounts);
        System.out.println(integer);
    }

    @Test
    void delAccount() {
        Integer integer = accountsMapper.delAccount("12312321123");
        System.out.println(integer);
    }

    @Test
    void setUsed() {
        Integer integer = accountsMapper.setUsed("12312321123");
        System.out.println(integer);
    }*/

}
