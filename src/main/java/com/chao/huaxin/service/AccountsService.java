package com.chao.huaxin.service;

import com.chao.huaxin.pojo.Accounts;

import java.util.List;

public interface AccountsService {


    List<Accounts> getAccounts(); List<Accounts> getAccountsCount();


    Accounts getAccountByAccount(String account);

    Integer saveAccount(Accounts accounts);

    Integer updateAccount(Accounts accounts);

}
