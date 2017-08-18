package com.cb.lee.domain.repository.account;

import com.cb.lee.domain.model.Account;
/**获取账户，添加更新账户 */
public interface AccountRepository {

    Account getAccountByUsername(String username);

    void insertAccount(Account account);

    void updateAccount(Account account);
}
