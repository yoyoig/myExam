package com.hand.dao;

import com.hand.pojo.Customer;

/**
 * Created by 铭刻 on 2017/8/15.
 */
public interface CustomerDao {


    Customer customerLogin(String firstName);

    int customerUpdate(Customer customer);

    Customer getCustomerById(short customerID);
}
