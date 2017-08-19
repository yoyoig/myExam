package com.hand.service.serviceImp;

import com.hand.dao.CustomerDao;
import com.hand.myException.LoginException;
import com.hand.pojo.Customer;
import com.hand.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 铭刻 on 2017/8/15.
 */
@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerDao dao;

    @Override
    public Customer customerLogin(Customer customer) {

        Customer customerReal = dao.customerLogin(customer.getFirstName());
        //若找不该用户，则抛出登录异常
        if (customerReal == null){
            throw new  LoginException();
        }else {
            //找到，则返回该用户
            return customerReal;
        }

    }

    @Override
    public Customer customerUpdate(Customer customer) {


        //创建当前修改时间
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateString  = format.format(date);
        Timestamp newdate = Timestamp.valueOf(dateString);
        customer.setLastUpdate(newdate);
        dao.customerUpdate(customer);
        return dao.getCustomerById(customer.getCustomerId());
    }
}
