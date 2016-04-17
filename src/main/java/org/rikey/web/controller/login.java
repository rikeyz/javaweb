package org.rikey.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.rikey.web.domain.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Description:
 * @Since 2016/4/14
 * @Author zhongrui8
 * @Changelist 1. 2016/4/14 create.
 * @Notice 如有改动，请在changelist中注明
 */
@Controller
public class login {
    @RequestMapping(value = {"/login.htm"}, method = RequestMethod.GET)
    public String indexMethod() {
        return "login";
    }

    @RequestMapping(value = {"/dologin.htm"}, method = RequestMethod.POST)
    public String doLogin(String userName, String password,Boolean remindMe, Model model) {
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        remindMe = remindMe == null ? false : true;
        token.setRememberMe(remindMe);
        Subject subject = SecurityUtils.getSubject();
        String msg;
        try {
            subject.login(token);
            if (subject.isAuthenticated()) {
                return "redirect:/";
            } else {
                model.addAttribute("msg", "用户名或密码错误");
                return "login";
            }
        } catch  (IncorrectCredentialsException e) {
            msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
            model.addAttribute("msg", msg);
            System.out.println(msg);
        } catch (ExcessiveAttemptsException e) {
            msg = "登录失败次数过多";
            model.addAttribute("msg", msg);
            System.out.println(msg);
        } catch (LockedAccountException e) {
            msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
            model.addAttribute("msg", msg);
            System.out.println(msg);
        } catch (DisabledAccountException e) {
            msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
            model.addAttribute("msg", msg);
            System.out.println(msg);
        } catch (ExpiredCredentialsException e) {
            msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
            model.addAttribute("msg", msg);
            System.out.println(msg);
        } catch (UnknownAccountException e) {
            msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
            model.addAttribute("msg", msg);
            System.out.println(msg);
        } catch (UnauthorizedException e) {
            msg = "您没有得到相应的授权！" + e.getMessage();
            model.addAttribute("msg", msg);
            System.out.println(msg);
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/index.htm"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"/logout.htm"}, method = RequestMethod.GET)
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login.htm";
    }

    @RequestMapping(value = {"/getMessage"}, method = RequestMethod.GET)
    @ResponseBody
    public Message getMessage(String userId) {
        Message msg = new Message();
        msg.setFrom("Jackie");
        msg.setMessage("ni hao ma");
        msg.setSendTime(new Date().toLocaleString());

        return msg;
    }
}
