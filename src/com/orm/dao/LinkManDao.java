package com.orm.dao;

import com.orm.domain.LinkMan;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * Created by harry.feng on 2018/3/31 .
 */
public interface LinkManDao {

   void save(LinkMan linkMan);

    List getLinkManList();

    List getLinkManList(DetachedCriteria detachedCriteria);
}
