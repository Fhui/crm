package com.orm.utils;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

/**
 * Created by harry.feng on 2018/4/26 .
 */
public class SpringUtils {


    public static WebApplicationContext getAcObj() {
        ServletContext servletContext = ServletActionContext.getServletContext();
        return WebApplicationContextUtils.getWebApplicationContext(servletContext);
    }

}
