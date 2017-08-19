package com.hand.interceptor;

import com.hand.pojo.Customer;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 铭刻 on 2017/8/15.
 */
class PowerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Customer customer = (Customer) httpServletRequest.getSession().getAttribute("customerLogin");
        if (customer==null){

            httpServletRequest.setAttribute("msg","请登录！");
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest,httpServletResponse);
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
