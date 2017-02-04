/*
 * Project: web
 * 
 * File Created at 2016/12/29
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhongrui
 * @Type PictureController.java
 * @Desc
 * @date 2016/12/29 16:09
 */
@RequestMapping(value = "/file")
@Controller
public class PictureController {

    private static final String IMG_BASE_PATH = "C:\\Users\\cmcc\\Documents\\personal\\dingchangbao\\javaweb\\src\\main\\webapp\\WEB-INF\\image\\" ;

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> uploadImage(@RequestParam("imageFile")MultipartFile file, HttpServletRequest request,
                              HttpServletResponse response, HttpSession session) {
        Map<String, String> result = new HashMap<String, String>();
        if (file != null) {
            String fileName = file.getOriginalFilename();
            File storedFile = new File(IMG_BASE_PATH + fileName);
            try {
                file.transferTo(storedFile);
            } catch (Exception e) {
                result.put("code", "0");
                result.put("msg", "server error");
                return result;
            }

            result.put("code", "1");
            result.put("file", fileName);
            return result;
        }

        result.put("code", "0");
        result.put("msg", "no file uploaded");
        return result;
    }

    @RequestMapping(value = "/getImage/{filename:[a-zA-Z0-9_\\\\.]+}", method = RequestMethod.GET)
    public void getImage(@PathVariable("filename")String fileName, HttpServletResponse response) {
        File outImage = new File(IMG_BASE_PATH + fileName);
        OutputStream out = null;
        FileInputStream fis = null;

        try {
            out = response.getOutputStream();
            fis = new FileInputStream(outImage);
            long fileSize = outImage.length();
            byte[] outBytes = new byte[fis.available()];
            fis.read(outBytes);
            out.write(outBytes);
            response.setContentType("image/jpeg");
            response.setHeader("Accept-Ranges", "bytes");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {

                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {

                }
            }

        }

    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.GET)
    public String getUploadPage() {
        return "upload/image";
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016/12/29 zhongrui creat
 */