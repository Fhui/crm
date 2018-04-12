package com.orm.web.servlet;

import com.orm.domain.LinkMan;
import com.orm.service.LinkManService;
import com.orm.service.impl.LinkManServiceImpl;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by harry.feng on 2018/3/31 .
 */
public class LinkManListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lkmName = req.getParameter("lkm_name");
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
        if (null != lkmName && !"".equals(lkmName)) {
            detachedCriteria.add(Restrictions.like("lkm_name", "%" + lkmName + "%"));
        }
        LinkManService service = new LinkManServiceImpl();
        List linkManList = service.getLinkManList(detachedCriteria);
        req.setAttribute("list", linkManList);
        req.getRequestDispatcher("/jsp/linkman/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
