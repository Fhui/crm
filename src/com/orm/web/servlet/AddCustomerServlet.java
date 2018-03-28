package com.orm.web.servlet;

import com.orm.domain.Customer;
import com.orm.service.CustomerService;
import com.orm.service.impl.CustomerServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by harry.feng on 2018/3/26 .
 */
public class AddCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String custName = req.getParameter("cust_name"); //客户姓名
        String custLevel = req.getParameter("cust_level"); //客户级别
        String custSource = req.getParameter("cust_source"); //信息来源
        String custLinkman = req.getParameter("cust_linkman"); //联系人
        String custPhone = req.getParameter("cust_phone"); //固定电话
        String custMobile = req.getParameter("cust_mobile"); //移动电话
        CustomerService service = new CustomerServiceImpl();
        Customer customer = new Customer();
        customer.setCust_name(custName);
        customer.setCust_level(custLevel);
        customer.setCust_source(custSource);
        customer.setCust_linkman(custLinkman);
        customer.setCust_phone(custPhone);
        customer.setCust_mobile(custMobile);
        service.save(customer);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
