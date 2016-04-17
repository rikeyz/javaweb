package org.rikey.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description:
 * @Since 2016/4/15
 * @Author zhongrui8
 * @Changelist 1. 2016/4/15 create.
 * @Notice 如有改动，请在changelist中注明
 */
@Controller
@RequestMapping(value = "/user")
public class Authority {
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String userDetail(String user) {
        return "detail";
    }
}
