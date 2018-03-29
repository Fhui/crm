package com.orm.web.servlet;

import com.orm.service.CustomerService;
import com.orm.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by harry.feng on 2018/3/29 .
 */
public class CustomerListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerService service = new CustomerServiceImpl();
        List allList = service.getAllList();
        req.setAttribute("list", allList);
        req.getRequestDispatcher("/jsp/customer/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
