package com.orm.service;

import com.orm.dao.impl.CustomerDaoImpl;
import com.orm.domain.Customer;

/**
 * Created by harry.feng on 2018/3/26 .
 */
public class CustomerServiceImpl implements CustomerService {
    @Override
    public void save(Customer customer) {
        CustomerDaoImpl dao = new CustomerDaoImpl();
        dao.save(customer);
    }
}
