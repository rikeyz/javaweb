package org.rikey.web.controller;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.rikey.web.dao.UserDao;
import org.rikey.web.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Random;

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

    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final int SALT_LENGTH = 6;

    @RequestMapping(value = "/register.htm", method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = {"/doregister"}, method = RequestMethod.POST)
    public String doregister(User user, Model model) {

        try {
            String password = user.getPassword();

            Random random = new Random();
            random.setSeed(System.nanoTime());

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < SALT_LENGTH; i ++) {
                int number = random.nextInt(CHARS.length());
                sb.append(CHARS.charAt(number));
            }

            String salt = sb.toString();
            String hashedPasswordBase64 = new Sha256Hash(password, salt).toBase64();
            user.setPassword(hashedPasswordBase64);
            user.setSalt(salt);

            userDao.addUser(user);
            return "redirect:/login.htm";
        } catch (Exception e) {
            model.addAttribute("errormsg", "添加用户失败");
            return "error";
        }

    }
}
