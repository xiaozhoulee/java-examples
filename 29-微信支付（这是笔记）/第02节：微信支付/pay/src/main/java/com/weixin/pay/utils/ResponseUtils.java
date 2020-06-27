package com.weixin.pay.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Project Name: com.weixin.pay.utils
 * File Name: ResponseUtils
 * Date: 2018-11-30 21:47
 * Copyright (c) 2018, 3141621744@qq.com All Rights Reserved.
 *
 * @author Tobin
 */
public class ResponseUtils {

    private final static Logger logger = LoggerFactory.getLogger(ResponseUtils.class);

    /**
     * Response
     * @param response
     * @param responseMsg
     */
    public static void response(HttpServletResponse response, String responseMsg) {
        if (responseMsg == null)
            return;

        try {
            byte[] msgs = responseMsg.getBytes("UTF-8");

            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Cache-Control", "no-store, max-age=0, no-cache, must-revalidate");
            response.addHeader("Cache-Control", "post-check=0, pre-check=0");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentLength(msgs.length);
            response.getOutputStream().write(msgs);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getRequestBody(HttpServletRequest request) {
        String retText = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "ISO-8859-1"));
            String tmp = null;
            StringBuffer htmlRet = new StringBuffer();
            while ((tmp = reader.readLine()) != null) {
                htmlRet.append(tmp).append("\n");
            }
            retText = new String(htmlRet.toString().trim().getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return retText;
    }

}


