package com.orm.web.servlet;

import com.orm.domain.Customer;
import com.orm.service.CustomerService;
import com.orm.service.impl.CustomerServiceImpl;
import com.sun.tools.javac.util.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

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
        String custName = req.getParameter("cust_name");
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        if (!(null == custName) && ! ("".equals(custName))) {
            detachedCriteria.add(Restrictions.like("cust_name", "%" + custName + "%"));
        }
        CustomerService service = new CustomerServiceImpl();
        List allList = service.getAllList(detachedCriteria);
        req.setAttribute("list", allList);
        req.getRequestDispatcher("/jsp/customer/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
