package com.chao.huaxin.dao;

import com.chao.huaxin.pojo.Accounts;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountsMapper {

    List<Accounts> getAccounts();
    List<Accounts> getAccountsCount();

    Accounts getAccountByAccount(String account);

    Integer saveAccount(Accounts accounts);

    Integer updateAccount(Accounts accounts);


}
