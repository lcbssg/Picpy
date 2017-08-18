package com.cb.lee.domain.service.account;

import com.cb.lee.domain.model.Account;
import com.cb.lee.domain.model.Address;

public interface AddressService {
    Address getAddress(Account account);
    
    void insertAddress(Address address);
    
    void updateAddress(Address address);
}
