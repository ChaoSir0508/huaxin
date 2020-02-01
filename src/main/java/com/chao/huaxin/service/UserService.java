package com.chao.huaxin.service;

import com.chao.huaxin.pojo.User;
import org.omg.CORBA.INTERNAL;

import java.util.List;

public interface UserService {


    User checkAccount(String account);

    Integer saveUser(User user);

    List<User> getUsers();

    User getUserById(Integer id);

    User getUserByAccount(String account);


    Integer updateUser(User user);

    List<User> listUser();

    Integer editUser(User user);

    Integer updateStatus(String account);

}
