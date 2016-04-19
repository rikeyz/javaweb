package org.rikey.web.controller;

import org.rikey.web.dao.UserDao;
import org.rikey.web.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * @Description:
 * @Since 2016/4/18
 * @Author zhongrui8
 * @Changelist 1. 2016/4/18 create.
 * @Notice 如有改动，请在changelist中注明
 */
@Controller
public class Register {

    @Resource(name = "userDao")
    private UserDao userDao;

    @RequestMapping(value = "/register.htm", method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = {"/doregister"}, method = RequestMethod.POST)
    public String doregister(User user, Model model) {

        try {
            userDao.addUser(user);
            return "redirect:/login.htm";
        } catch (Exception e) {
            model.addAttribute("errormsg", "添加用户失败");
            return "error";
        }

    }
}
