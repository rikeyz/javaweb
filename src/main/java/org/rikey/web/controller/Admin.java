/*
 * Project: web
 * 
 * File Created at 2016/12/22
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package org.rikey.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhongrui
 * @Type Admin.java
 * @Desc
 * @date 2016/12/22 20:03
 */
@Controller
@RequestMapping("/admin")
public class Admin {

    @RequestMapping(value = {"","/"})
    public String showAdmin() {
        return "admin/admin";
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016/12/22 zhongrui creat
 */