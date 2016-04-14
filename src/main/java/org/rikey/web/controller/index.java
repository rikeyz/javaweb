package org.rikey.web.controller;

import org.rikey.web.domain.Message;
import org.springframework.stereotype.Controller;
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
public class index {
    @RequestMapping(value = {"/", "/index.htm"}, method = RequestMethod.GET)
    public String indexMethod() {
        return "index";
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
