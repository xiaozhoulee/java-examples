package com.weixin.pay.controller;

import com.weixin.pay.api.WXPayUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * Project Name: com.weixin.pay.controller
 * File Name: WXPayRefundQueryController
 * Copyright (c) 2018, 3141621744@qq.com All Rights Reserved.
 *
 * @author Tobin
 */
@Controller
public class WXPayRefundQueryController {

    @GetMapping("/refundquery")
    public String refundquery() {
        return "/refundquery";
    }

    @PostMapping("/refundquery")
    public String refundquery(ModelMap map, String orderNo) throws Exception {
        WXPayUtils wxPayUtils = new WXPayUtils();
        Map<String, String> rs = wxPayUtils.wxRefundQuery(orderNo);

        System.out.println("==================== 退款查询结果 ==============");
        System.out.println(rs);

        map.put("refundqueryMap", rs.toString());
        return "/refundquery";
    }

}
