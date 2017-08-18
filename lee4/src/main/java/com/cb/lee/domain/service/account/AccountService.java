package com.cb.lee.domain.service.account;

import com.cb.lee.domain.model.Account;

public interface AccountService {
    Account getAccount(String username);

    void insertAccount(Account account);

    void updateAccount(Account account);

}
