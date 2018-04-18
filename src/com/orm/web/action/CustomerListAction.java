package com.orm.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.orm.domain.Customer;
import com.orm.service.CustomerService;
import com.orm.service.impl.CustomerServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by harry.feng on 2018/4/18 .
 */
public class CustomerListAction extends ActionSupport {

    public String getCustomerList() {
        String custName = ServletActionContext.getRequest().getParameter("cust_name");
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        if (StringUtils.isNoneBlank(custName)) { //判空
            detachedCriteria.add(Restrictions.like("cust_name", "%" + custName + "%"));
        }
        CustomerService service = new CustomerServiceImpl();
        List allList = service.getAllList(detachedCriteria);
        ServletActionContext.getRequest().setAttribute("list", allList);
        return "list";
    }

}
