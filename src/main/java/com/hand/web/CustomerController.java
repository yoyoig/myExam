package com.hand.web;

import com.hand.DTO.LoginSuccess;
import com.hand.myException.LoginException;
import com.hand.pojo.Customer;
import com.hand.service.CustomerService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.List;

/**
 * Created by 铭刻 on 2017/8/15.
 */
@Controller
@RequestMapping("/customer")
@SessionAttributes("customerLogin")
public class CustomerController {

    @Autowired
    private CustomerService service;

//    @RequestMapping(value = "/customerLogin",method = RequestMethod.POST)
//    public String customerLogin(Customer customer, Model model){
//
//        if (customer.getFirstName()==null || customer.getFirstName().equals("")){
//            model.addAttribute("msg","用户名不能为空！！");
//            return "/login.jsp";
//        }else {
//
//
//            try {
//                Customer customerLogin = service.customerLogin(customer);
//                model.addAttribute("customerLogin", customerLogin);
//                return "redirect:/film/queryAll";
//            } catch (LoginException e) {
//                model.addAttribute("msg", "该客户不存在！");
//                return "/login.jsp";
//            }
//        }
//    }

    /**
     * 前后端分离尝试
     * @param customer
     * @return
     */

    @RequestMapping(value = "/customerLogin",method = RequestMethod.POST)
    public @ResponseBody LoginSuccess customerLogin(Customer customer,Model model){
        LoginSuccess loginSuccess = new LoginSuccess();

        try {
            Customer customerLogin = service.customerLogin(customer);
            model.addAttribute("customerLogin",customerLogin);
            loginSuccess.setLogin(true);
            return loginSuccess;
        } catch (Exception e) {
            loginSuccess.setLogin(false);
            return loginSuccess;
        }


    }

    /**
     * customer登录
     * @param session
     * @return
     */
    @RequestMapping(value = "/customerLogout",method = RequestMethod.GET)
    public String customerLogout(HttpSession session){

        session.removeAttribute("customerLogin");
        return "redirect:/login.jsp";

    }


    @RequestMapping(value = "/customerUpdate",method = RequestMethod.POST)
    public String customerUpdate(@Validated Customer customer, BindingResult result, Model model){

        //非空验证
        if(result.hasErrors()){

            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error:errors) {
                model.addAttribute("msg",error.getDefaultMessage());
            }

            return "/film/queryAll";

        }else {

            //更新customer,并返回新customer
            System.out.println(customer);
            Customer newCustomer = service.customerUpdate(customer);
            //更新当前登录customer
            model.addAttribute("customerLogin", newCustomer);
            return "redirect:/film/queryAll";
        }

    }

}
