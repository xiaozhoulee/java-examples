package com.weixin.pay.controller;

import com.weixin.pay.api.WXPayConfig;
import com.weixin.pay.api.WXPayUtils;
import com.weixin.pay.api.WXRefundUtils;
import com.weixin.pay.sdk.WXPayConstants;
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
 * File Name: WXPayRefundController
 * Copyright (c) 2018, 3141621744@qq.com All Rights Reserved.
 *
 * @author Tobin
 */
@Controller
public class WXPayRefundController {

    @Value("${pays.http}")
    private String payHttp;

    private final String callBack = "/refund/callback";

    @GetMapping("/payrefund")
    public String payrefund() {
        return "/payrefund";
    }

    @PostMapping("/payrefund")
    public String payrefund(ModelMap map, String orderNo, String refundNo, String price) throws Exception {
        WXPayUtils wxPayUtils = new WXPayUtils();

        String url = payHttp + callBack;
        Map<String, String> rs =  wxPayUtils.wxRefund(url, orderNo, refundNo, price, price);

        System.out.println("=============申请退款===========");
        System.out.println(rs);

        map.put("payrefundMap", rs.toString());

        return "/payrefund";
    }

    /**
     * 退款结果通知
     * @return
     * @throws Exception
     */
    @PostMapping(callBack)
    public void notifyRefund(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String retText = ResponseUtils.getRequestBody(request);
        Map<String, String> rsmap = WXPayUtil.xmlToMap(retText);

        String return_code = rsmap.get("return_code");
        if (WXPayConstants.SUCCESS.equals(return_code)) {
            String req_info = rsmap.get("req_info");

            String xmlStr = WXRefundUtils.getRefundDecrypt(req_info, WXPayConfig.getKey());
            Map<String, String> map = WXPayUtil.xmlToMap(xmlStr);

            String out_trade_no = map.get("out_trade_no");
            String out_refund_no = map.get("out_refund_no");

            String refund_id = map.get("refund_id");
            String refund_fee = map.get("refund_fee");
            String settlement_refund_fee = map.get("settlement_refund_fee");
            String refund_status = map.get("refund_status");
            String success_time = map.get("success_time");
            String refund_recv_accout = map.get("refund_recv_accout");

            if (out_refund_no != null) {

                // 写入数据库
                System.out.println("===========退款回调===========");
                System.out.println("商户订单号:" + out_trade_no);
                System.out.println("商户退款单号:" + out_refund_no);
                System.out.println("微信退款单号:" + refund_id);
                System.out.println("申请退款金额:" + refund_fee);
                System.out.println("退款金额:" + settlement_refund_fee);  // 退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
                System.out.println("退款状态:" + refund_status);          // SUCCESS-退款成功  CHANGE-退款异常    REFUNDCLOSE—退款关闭
                System.out.println("退款成功时间:" + success_time);       // 资金退款至用户帐号的时间，格式2017-12-15 09:46:01
                System.out.println("退款入账账户" + refund_recv_accout);

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

}


