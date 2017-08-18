package com.cb.lee.domain.service.account;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cb.lee.domain.model.Account;
import com.cb.lee.domain.model.Address;
import com.cb.lee.domain.repository.account.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

    @Inject
    private AddressRepository AddressRepository;

    @Override
    //通过用户名获取账户
    public Address getAddress(Account account) {
        return AddressRepository.getAddress(account);
    }

    @Override
    @Transactional
    //通过账户添加账户，简介和注册信息
    public void insertAddress(Address Address) {
        AddressRepository.insertAddress(Address);
    }

    @Override
    @Transactional
    //通过账户更新账户，简介和信息
    public void updateAddress(Address Address) {
        AddressRepository.updateAddress(Address);
    }
}
