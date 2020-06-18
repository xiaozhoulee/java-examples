package com.weixin.pay.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Project Name: com.weixin.pay.utils
 * File Name: HttpClientUtils
 * Date: 2018-11-30 21:45
 * Copyright (c) 2018, 3141621744@qq.com All Rights Reserved.
 *
 * @author Tobin
 */
public class HttpClientUtils {

    //编码格式。发送编码格式统一用UTF-8
    private static final String ENCODING = "UTF-8";

    private final static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * Post JOSN
     * @param url
     * @param json
     * @return
     */
    public static String post(String url, String json) {
        logger.info("Post URL=" + url);
        logger.info("Post Data=" + json);

        StringBuffer requestText = new StringBuffer();

        CloseableHttpResponse response = null;
        CloseableHttpClient client = null;
        HttpPost httpPost = new HttpPost(url);
        StringEntity entityParams = null;
        try {
            entityParams = new StringEntity(json, "utf-8");
            httpPost.setEntity(entityParams);
            httpPost.setHeader("Content-Type", "type/json;charset=ISO-8859-1");
            client = HttpClients.createDefault();
            response = client.execute(httpPost);
            byte[] x = EntityUtils.toByteArray(response.getEntity());
            requestText.append(new String(x, "utf-8"));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            logger.info("Request=" + requestText.toString());
        }
        return requestText.toString();
    }

    /**
     * 基于HttpClient 4.5的通用GET方法
     *
     * @param url       提交的URL
     * @return 提交响应
     */
    public static String get(String url) throws RuntimeException {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpGet get = new HttpGet(url);
            response = client.execute(get);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, ENCODING);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (response != null)
                    response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }

}

