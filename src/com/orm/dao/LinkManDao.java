package com.orm.dao;

import com.orm.domain.LinkMan;

import java.util.List;

/**
 * Created by harry.feng on 2018/3/31 .
 */
public interface LinkManDao {

   void save(LinkMan linkMan);

    List getLinkManList();
}
