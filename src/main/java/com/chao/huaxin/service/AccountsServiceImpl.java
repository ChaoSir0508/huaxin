package com.chao.huaxin.service;

import com.chao.huaxin.dao.AccountsMapper;
import com.chao.huaxin.pojo.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsServiceImpl implements AccountsService {

    @Autowired
    private AccountsMapper accountsMapper;

    @Override
    public List<Accounts> getAccounts() {
        return accountsMapper.getAccounts();
    }

    @Override
    public List<Accounts> getAccountsCount() {
        return accountsMapper.getAccountsCount();
    }

    @Override
    public Accounts getAccountByAccount(String account) {
        return accountsMapper.getAccountByAccount(account);
    }

    @Override
    public Integer saveAccount(Accounts accounts) {
        return accountsMapper.saveAccount(accounts);
    }

    @Override
    public Integer updateAccount(Accounts accounts) {
        return accountsMapper.updateAccount(accounts);
    }
}
