package com.orm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.orm.domain.LinkMan;
import com.orm.service.LinkManService;
import com.orm.service.impl.LinkManServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by harry.feng on 2018/4/19 .
 */
public class LinkmanAction extends ActionSupport implements ModelDriven<LinkMan> {

    private LinkMan linkMan = new LinkMan();
    private LinkManService service = new LinkManServiceImpl();

    public String getList() {
        String search = linkMan.getLkm_name();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
        if (StringUtils.isNoneBlank(search)) {
            detachedCriteria.add(Restrictions.like("lkm_name", "%" + search + "%"));
        }
        List linkManList = service.getLinkManList(detachedCriteria);
        ActionContext.getContext().put("linkmanlist", linkManList);
        return "list";
    }

    public String addLinkman() {
        service.save(linkMan);
        return "toList";
    }


    @Override
    public LinkMan getModel() {
        return linkMan;
    }
}
