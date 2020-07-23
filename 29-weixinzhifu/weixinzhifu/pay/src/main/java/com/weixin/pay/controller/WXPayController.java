package com.weixin.pay.controller;

import com.weixin.pay.api.WXPayConfig;
import com.weixin.pay.api.WXPayUtils;
import com.weixin.pay.sdk.WXPayUtil;
import com.weixin.pay.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Project Name: com.weixin.pay.controller
 * File Name: WXPayController
 * Date: 2018-11-30 22:06
 * Copyright (c) 2018, 3141621744@qq.com All Rights Reserved.
 *
 * @author Tobin
 */
@Controller
public class WXPayController {

    @Value("${pays.http}")
    private String payHttp;

    private final String callBack = "/pay/callback";

    @GetMapping("/pay")
    public String pay() {
        return "pay";
    }

    @PostMapping("/pay")
    public String pay(ModelMap map, String orderNo, String body, String price) throws Exception {
        WXPayUtils wxPayUtils = new WXPayUtils();

        String url = payHttp + callBack;
        Map<String, String> rs = wxPayUtils.wxPay(url, orderNo, String.valueOf(price), "192.168.1.1", body, "123456");

        System.out.println("=============微信统一下单, 获取的微信返回结果===========-=====");
        System.out.println(rs);

        map.put("code_url", rs.get("code_url"));
        return "/paycode";
    }

    /**
     * 支付结果通知
     * @return
     * @throws Exception
     */
    @PostMapping(callBack)
    public void notifyOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取request返回的值
        String retText = ResponseUtils.getRequestBody(request);
        Map<String, String> map = WXPayUtil.xmlToMap(retText);

        // 检查签名信息
        boolean sign = WXPayUtil.isSignatureValid(map, WXPayConfig.getKey());
        if (sign) {
            String wxouttradeno = map.get("out_trade_no");
            String wxappid = map.get("appid");
            String wxmchid = map.get("mch_id");
            String wxbanktype = map.get("bank_type");
            String wxcashfee = map.get("cash_fee");
            String wxtotalfee = map.get("total_fee");
            String wxissubscribe = map.get("is_subscribe");
            String wxopenid = map.get("openid");
            String wxtimeend = map.get("time_end");
            String wxtradetype = map.get("trade_type");
            String wxtransactionid = map.get("transaction_id");

            // 写入数据库
            System.out.println("===========支付回调===========");
            System.out.println("商户订单号:" + wxouttradeno);
            System.out.println("APPID:" + wxappid);
            System.out.println("商户ID:" + wxmchid);
            System.out.println("付款银行:" + wxbanktype);
            System.out.println("现金支付金额:" + wxcashfee);
            System.out.println("订单金额:" + wxtotalfee);
            System.out.println("是否关注公众账号:" + wxissubscribe);
            System.out.println("用户标识:" + wxopenid);
            System.out.println("支付完成时间:" + wxtimeend);
            System.out.println("交易类型:" + wxtradetype);  // JSAPI、NATIVE、APP
            System.out.println("微信支付订单号:" + wxtransactionid);

            // 响应完成到微信
            StringBuilder sb = new StringBuilder();
            sb.append("<xml>");
            sb.append("<return_code><![CDATA[SUCCESS]]></return_code>");
            sb.append("<return_msg><![CDATA[OK]]></return_msg>");
            sb.append("</xml>");

            ResponseUtils.response(response, sb.toString());
        }
    }


}
