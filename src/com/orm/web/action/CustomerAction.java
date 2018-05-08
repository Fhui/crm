package com.orm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.orm.domain.Customer;
import com.orm.service.CustomerService;
import com.orm.service.impl.CustomerServiceImpl;
import com.orm.utils.SpringUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * 联系人 Action
 * Created by harry.feng on 2018/4/18 .
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();
    private CustomerService service = (CustomerService) SpringUtils.getAcObj().getBean("customService");

    public String getCustomerList() {
        String custName = customer.getCust_name();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        if (StringUtils.isNoneBlank(custName)) { //判空
            detachedCriteria.add(Restrictions.like("cust_name", "%" + custName + "%"));
        }
        List allList = service.getAllList(detachedCriteria);
        ActionContext.getContext().put("list", allList);
        return "list";
    }


    public String addCustomer() {
        service.save(customer);
        return "toList";
    }

    @Override
    public Customer getModel() {
        return customer;
    }
}
