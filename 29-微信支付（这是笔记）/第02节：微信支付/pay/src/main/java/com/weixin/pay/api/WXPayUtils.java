package com.weixin.pay.api;

import com.weixin.pay.sdk.WXPayUtil;
import com.weixin.pay.utils.HttpCertClientUtils;
import com.weixin.pay.utils.HttpClientUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Project Name: com.weixin.pay.api
 * File Name: WXPayUtils
 * Date: 2018-11-30 22:14
 * Copyright (c) 2018, 3141621744@qq.com All Rights Reserved.
 *
 * @author Tobin
 */
public class WXPayUtils {

    /**
     * 微信统一下单接口
     * @param notify_url     回调地址
     * @param out_trade_no   商户订单号
     * @param total_fee      订单总金额
     * @param ip             IP
     * @param body           商品内容描述
     * @param openid         微信用户 OPENID
     * @return
     * @throws Exception
     */
    public Map<String, String> wxPay(String notify_url, String out_trade_no, String total_fee, String ip, String body, String openid) throws Exception {
        Map<String, String> mp = new HashMap();
        mp.put("appid", WXPayConfig.getAppID());                        // 公众账号ID
        mp.put("mch_id", WXPayConfig.getMchID());                       // 商户号
        mp.put("nonce_str", WXPayUtil.generateNonceStr());              // 随机字符串
        mp.put("body", body);                                           // 商品描述
        mp.put("out_trade_no", out_trade_no);                           // 商户订单号
        mp.put("total_fee", total_fee);                                 // 订单总金额, 单位为分
        mp.put("spbill_create_ip", ip);                                 // 终端IP
        mp.put("notify_url", notify_url);                               // 异步接收微信支付结果通知的回调地址, 通知url必须为外网可访问的url, 不能携带参数
        mp.put("trade_type", "NATIVE");                                 // 交易类型(JSAPI公众号支付/NATIVE扫码支付/APP支付)
        mp.put("product_id", out_trade_no);                             // trade_type=NATIVE时(即扫码支付), 此参数必传. 此参数为二维码中包含的商品ID, 商户自行定义。
        String sign = WXPayUtil.generateSignature(mp, WXPayConfig.getKey());

        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<appid>" + mp.get("appid") + "</appid>");
        sb.append("<mch_id><![CDATA[" + mp.get("mch_id") + "]]></mch_id>");
        sb.append("<nonce_str><![CDATA[" + mp.get("nonce_str") + "]]></nonce_str>");
        sb.append("<body><![CDATA[" + mp.get("body") + "]]></body>");
        sb.append("<out_trade_no><![CDATA[" + mp.get("out_trade_no") + "]]></out_trade_no>");
        sb.append("<total_fee>" + mp.get("total_fee") + "</total_fee>");
        sb.append("<spbill_create_ip><![CDATA[" + mp.get("spbill_create_ip") + "]]></spbill_create_ip>");
        sb.append("<notify_url><![CDATA[" + mp.get("notify_url") + "]]></notify_url>");
        sb.append("<trade_type><![CDATA[" + mp.get("trade_type") + "]]></trade_type>");
        sb.append("<product_id><![CDATA[" + mp.get("product_id") + "]]></product_id>");
        sb.append("<sign><![CDATA[" + sign + "]]></sign>");
        sb.append("</xml>");

        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        String str = HttpClientUtils.post(url, sb.toString());

        Map<String, String> retmap = new HashMap();
        try {
            retmap = WXPayUtil.xmlToMap(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retmap;
    }


    /**
     * 微信查询
     * @param out_trade_no    商户订单号
     * @return
     * @throws Exception
     */
    public Map<String, String> wxOrderQuery(String out_trade_no) throws Exception {
        Map<String, String> mp = new HashMap<>();
        mp.put("appid", WXPayConfig.getAppID());                                // 公众账号ID
        mp.put("mch_id", WXPayConfig.getMchID());                               // 商户号
        // mp.put("transaction_id", transaction_id);                            // 微信订单号 (2 S 1)
        mp.put("out_trade_no", out_trade_no);                                   // 商户订单号 (2 S 1)
        mp.put("nonce_str", WXPayUtil.generateNonceStr());                      // 随机字符串
        String sign = WXPayUtil.generateSignature(mp, WXPayConfig.getKey());

        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<appid>" + mp.get("appid") + "</appid>");
        sb.append("<mch_id><![CDATA[" + mp.get("mch_id") + "]]></mch_id>");
        sb.append("<out_trade_no><![CDATA[" + mp.get("out_trade_no") + "]]></out_trade_no>");
        sb.append("<nonce_str>" + mp.get("nonce_str") + "</nonce_str>");
        sb.append("<sign><![CDATA[" + sign + "]]></sign>");
        sb.append("</xml>");

        String url = "https://api.mch.weixin.qq.com/pay/orderquery";
        String str = HttpClientUtils.post(url, sb.toString());

        Map<String, String> retmap = new HashMap<>();
        try {
            retmap = WXPayUtil.xmlToMap(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retmap;
    }

    /**
     * 关闭订单
     * @param out_trade_no       商户订单号
     * @return
     * @throws Exception
     */
    public Map<String, String> wxCloseOrder(String out_trade_no) throws Exception {
        Map<String, String> mp = new HashMap<>();
        mp.put("appid", WXPayConfig.getAppID());                                // 公众账号ID
        mp.put("mch_id", WXPayConfig.getMchID());                               // 商户号
        mp.put("out_trade_no", out_trade_no);                                   // 商户订单号 (2 S 1)
        mp.put("nonce_str", WXPayUtil.generateNonceStr());                      // 随机字符串
        String sign = WXPayUtil.generateSignature(mp, WXPayConfig.getKey());

        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<appid>" + mp.get("appid") + "</appid>");
        sb.append("<mch_id><![CDATA[" + mp.get("mch_id") + "]]></mch_id>");
        sb.append("<out_trade_no><![CDATA[" + mp.get("out_trade_no") + "]]></out_trade_no>");
        sb.append("<nonce_str>" + mp.get("nonce_str") + "</nonce_str>");
        sb.append("<sign><![CDATA[" + sign + "]]></sign>");
        sb.append("</xml>");

        String url = "https://api.mch.weixin.qq.com/pay/closeorder";
        String str = HttpClientUtils.post(url, sb.toString());

        Map<String, String> retmap = new HashMap<>();
        try {
            retmap = WXPayUtil.xmlToMap(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retmap;
    }


    /**
     * 申请退款
     * @param notify_url       退款结果通知url
     * @param out_trade_no     商户订单号
     * @param out_refund_no    商户退款单号
     * @param total_fee        订单金额
     * @param refund_fee       退款金额
     * @return
     * @throws Exception
     */
    public Map<String, String> wxRefund(String notify_url, String out_trade_no, String out_refund_no, String total_fee, String refund_fee) throws Exception {
        Map<String, String> mp = new HashMap<>();
        mp.put("appid", WXPayConfig.getAppID());                                // 公众账号ID
        mp.put("mch_id", WXPayConfig.getMchID());                               // 商户号
        mp.put("nonce_str", WXPayUtil.generateNonceStr());                      // 随机字符串
        // mp.put("transaction_id", transaction_id);                            // 微信订单号 (2 S 1)
        mp.put("out_trade_no", out_trade_no);                                   // 商户订单号 (2 S 1)
        mp.put("out_refund_no", out_refund_no);                                 // 商户退款单号
        mp.put("total_fee", total_fee);                                         // 订单金额
        mp.put("refund_fee", refund_fee);                                       // 退款金额
        if (!StringUtils.isEmpty(notify_url))
            mp.put("notify_url", notify_url);                                       // 退款结果通知url
        String sign = WXPayUtil.generateSignature(mp, WXPayConfig.getKey());

        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<appid>" + mp.get("appid") + "</appid>");
        sb.append("<mch_id><![CDATA[" + mp.get("mch_id") + "]]></mch_id>");
        sb.append("<nonce_str>" + mp.get("nonce_str") + "</nonce_str>");
        sb.append("<out_trade_no><![CDATA[" + mp.get("out_trade_no") + "]]></out_trade_no>");
        sb.append("<out_refund_no><![CDATA[" + mp.get("out_refund_no") + "]]></out_refund_no>");
        sb.append("<total_fee><![CDATA[" + mp.get("total_fee") + "]]></total_fee>");
        sb.append("<refund_fee><![CDATA[" + mp.get("refund_fee") + "]]></refund_fee>");
        if (!StringUtils.isEmpty(notify_url))
            sb.append("<notify_url><![CDATA[" + mp.get("notify_url") + "]]></notify_url>");
        sb.append("<sign><![CDATA[" + sign + "]]></sign>");
        sb.append("</xml>");

        String url = "https://api.mch.weixin.qq.com/secapi/pay/refund";
        String str = new HttpCertClientUtils().post(url, sb.toString(), CertConfig.getCert(), WXPayConfig.getMchID());

        Map<String, String> retmap = new HashMap<>();
        try {
            retmap = WXPayUtil.xmlToMap(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retmap;
    }

    /**
     * 查询退款
     * @param out_trade_no   商户订单号
     * @return
     * @throws Exception
     */
    public Map<String, String> wxRefundQuery(String out_trade_no) throws Exception {
        Map<String, String> mp = new HashMap<>();
        mp.put("appid", WXPayConfig.getAppID());                                // 公众账号ID
        mp.put("mch_id", WXPayConfig.getMchID());                               // 商户号
        mp.put("nonce_str", WXPayUtil.generateNonceStr());                      // 随机字符串
        // mp.put("transaction_id", transaction_id);                            // 微信订单号 (4 S 1)
        // mp.put("out_refund_no", out_refund_no);                              // 商户退款单号 (4 S 1)
        // mp.put("refund_id", refund_id);                                      // 微信退款单号 (4 S 1)
        mp.put("out_trade_no", out_trade_no);                                   // 商户订单号 (4 S 1)
        String sign = WXPayUtil.generateSignature(mp, WXPayConfig.getKey());

        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<appid>" + mp.get("appid") + "</appid>");
        sb.append("<mch_id><![CDATA[" + mp.get("mch_id") + "]]></mch_id>");
        sb.append("<nonce_str>" + mp.get("nonce_str") + "</nonce_str>");
        sb.append("<out_trade_no><![CDATA[" + mp.get("out_trade_no") + "]]></out_trade_no>");
        sb.append("<sign><![CDATA[" + sign + "]]></sign>");
        sb.append("</xml>");

        String url = "https://api.mch.weixin.qq.com/pay/refundquery";
        String str = HttpClientUtils.post(url, sb.toString());

        Map<String, String> retmap = new HashMap<>();
        try {
            retmap = WXPayUtil.xmlToMap(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retmap;
    }




}
