package com.orm.web.servlet;

import com.orm.domain.LinkMan;
import com.orm.service.LinkManService;
import com.orm.service.impl.LinkManServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by harry.feng on 2018/3/31 .
 */
public class AddLinkManServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LinkMan linkMan = new LinkMan();
        try {
            BeanUtils.populate(linkMan, req.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        LinkManService service = new LinkManServiceImpl();
        service.save(linkMan);
        resp.sendRedirect(req.getContextPath() + "/linkManList");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
