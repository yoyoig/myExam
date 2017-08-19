package com.hand.service;

import com.hand.pojo.Customer;

/**
 * Created by 铭刻 on 2017/8/15.
 */
public interface CustomerService {

    Customer customerLogin(Customer customer);

    Customer customerUpdate(Customer customer);
}
