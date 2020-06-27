package com.weixin.pay.api;

/**
 * Project Name: com.weixin.pay.api
 * File Name: WXRefundUtils
 * Copyright (c) 2018, 3141621744@qq.com All Rights Reserved.
 *
 * @author Tobin
 */

import com.weixin.pay.sdk.WXPayUtil;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

/**
 * 微信退款加密字段解密
 */
public class WXRefundUtils {

    public static String getRefundDecrypt(String reqInfoSecret, String key) {
        String result = "";
        try {
            Security.addProvider(new BouncyCastleProvider());
            sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
            byte[] bt = decoder.decodeBuffer(reqInfoSecret);
            String b = new String(bt);
            String md5key = WXPayUtil.MD5(key).toLowerCase();
            SecretKey secretKey = new SecretKeySpec(md5key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] resultbt = cipher.doFinal(bt);
            result = new String(resultbt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}

