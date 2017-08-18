package com.cb.lee.domain.service.user;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cb.lee.domain.model.Account;
import com.cb.lee.domain.service.account.AccountService;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Inject
    protected AccountService accountService;

    //验证用户名不为空
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.getAccount(username);
        if (account == null) {
            throw new UsernameNotFoundException(username + "该用户名不存在");
        }
        return new com.cb.lee.domain.model.UserDetails(account);
    }
}
