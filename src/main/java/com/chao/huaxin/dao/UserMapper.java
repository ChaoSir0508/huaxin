package com.chao.huaxin.dao;

import com.chao.huaxin.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import javax.jws.soap.SOAPBinding;
import java.net.UnknownServiceException;
import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getUsers();

    User gerUserById(Integer id);
    User getUserByAccount(String  account);

    Integer saveUser(User user);

    Integer updateUser(User user);

    Integer updateStatus(String account);

    User getAccount(String account);

    Integer setStatus(String account);

    List<User> listUser();

    Integer editUser(User user);

}
