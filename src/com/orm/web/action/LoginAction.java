package com.orm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.orm.domain.User;
import com.orm.service.UserService;
import com.orm.service.impl.UserServiceImpl;

/**
 * 登陆Action
 * Created by harry.feng on 2018/4/21 .
 */
public class LoginAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();

    public String login() {
        UserService service = new UserServiceImpl();
        User queryUser = service.login(user);
        ActionContext.getContext().put("user", queryUser);
        return "toIndex";
    }

    @Override
    public User getModel() {
        return user;
    }
}
