package com.weixin.pay.controller;

import com.weixin.pay.api.WXPayUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * Project Name: com.weixin.pay.controller
 * File Name: WXPayCloseConntroller
 * Copyright (c) 2018, 3141621744@qq.com All Rights Reserved.
 *
 * @author Tobin
 */
@Controller
public class WXPayCloseConntroller {

    @GetMapping("/payclose")
    public String payclose() {
        return "/payclose";
    }

    @PostMapping("/payclose")
    public String payclose(ModelMap map , String orderNo) throws Exception {
        WXPayUtils wxPayUtils = new WXPayUtils();
        Map<String, String> rs = wxPayUtils.wxCloseOrder(orderNo);

        System.out.println("================关闭订单 ==============");
        System.out.println(rs);

        map.put("paycloseMap", rs.toString());
        return "/payclose";
    }


}
