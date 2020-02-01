package com.chao.huaxin.service;

import com.chao.huaxin.dao.UserMapper;
import com.chao.huaxin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkAccount(String account) {
        User exist = userMapper.getAccount(account);
        return exist;
    }

    @Override
    public Integer saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.gerUserById(id);
    }

    @Override
    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @Override
    public Integer editUser(User user) {
        return userMapper.editUser(user);
    }

    @Override
    public Integer updateStatus(String account) {
        return userMapper.updateStatus(account);
    }
}
