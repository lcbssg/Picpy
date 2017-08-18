package com.cb.lee.domain.service.account;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cb.lee.domain.model.Account;
import com.cb.lee.domain.repository.account.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    @Inject
    private AccountRepository accountRepository;

    @Override
    //通过用户名获取账户
    public Account getAccount(String username) {
        return accountRepository.getAccountByUsername(username);
    }

    @Override
    @Transactional
    //通过账户添加账户，简介和注册信息
    public void insertAccount(Account account) {
        accountRepository.insertAccount(account);
    }

    @Override
    @Transactional
    //通过账户更新账户，简介和信息
    public void updateAccount(Account account) {
        accountRepository.updateAccount(account);
    }
}
