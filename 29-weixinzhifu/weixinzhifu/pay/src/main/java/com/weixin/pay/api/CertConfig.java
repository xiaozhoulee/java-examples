package com.weixin.pay.api;

/**
 * Project Name: com.weixin.pay.api
 * File Name: CertConfig
 * Copyright (c) 2018, 3141621744@qq.com All Rights Reserved.
 *
 * @author Tobin
 */
public class CertConfig {

    /**
     * 微信证书
     * @return
     */
    public static String getCert() {
        String separator = System.getProperty("file.separator");
        return CertConfig.getClassPath() + separator + "static" + separator + "cert" + separator +  "apiclient_cert.p12";
    }

    /**
     * 获取系统路径
     * @return
     */
    public static String getClassPath() {
        String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
        String temp = path.replaceFirst("file:/", "");
        String separator = System.getProperty("file.separator");
        String resultPath = temp.replaceAll("/", separator + separator);
        return resultPath;
    }

}
