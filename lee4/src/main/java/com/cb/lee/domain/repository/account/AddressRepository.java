package com.cb.lee.domain.repository.account;


import com.cb.lee.domain.model.Account;
import com.cb.lee.domain.model.Address;
/**获取地址，添加更新地址 */
public interface AddressRepository {

    Address getAddress(Account account);
    
    void insertAddress(Address address);
    
    void updateAddress(Address address);
}
