/*
 * Project: web
 * 
 * File Created at 2017/2/4
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
 * @Type NotFoundController.java
 * @Desc
 * @date 2017/2/4 15:38
 */
@Controller
public class ErrorPageController {
    @RequestMapping(value = {"/404.html"})
    public String _404NotFound() {
        return "404";
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017/2/4 zhongrui creat
 */