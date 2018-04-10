package com.orm.dao;

import com.orm.domain.Customer;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * Created by harry.feng on 2018/3/26 .
 */
public interface CustomerDao {

    void save(Customer customer);

    List getAllList();

    Customer getCustomerById(Long id);

    List getAllList(DetachedCriteria criteria);
}
