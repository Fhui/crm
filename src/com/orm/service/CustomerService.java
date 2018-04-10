package com.orm.service;

import com.orm.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * Created by harry.feng on 2018/3/26 .
 */
public interface CustomerService {

    void save(Customer customer);

    List getAllList();

    List getAllList(DetachedCriteria detachedCriteria);
}
