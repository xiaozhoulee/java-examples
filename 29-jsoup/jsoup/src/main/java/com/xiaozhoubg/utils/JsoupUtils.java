package com.xiaozhoubg.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class JsoupUtils {
//    模拟请求 https://search.jd.com/Search?keyword=%E6%BB%91%E6%9D%BF
public static void main(String[] args) throws IOException {
    String url ="https://search.jd.com/Search?keyword=lenovo";

            //解析网页。返回的Document就是浏览器Document对象
    Document parse = Jsoup.parse(new URL(url), 30000);
    //所有你在js中使用的方法，这里也可以使用（ajax不能用）

//    1.获取 #J_goodsList 下的元素
    Element element = parse.getElementById("J_goodsList");

//    System.out.println(element);
    //2 获取 #J_goodsList 下全部 li 标签
    Elements li = element.getElementsByTag("li");
    for (Element element1 : li) {
        //商品图片
        String img = element1.getElementsByTag("img").eq(0).attr("data-lazy-img");
        //商品标题
        String title = element1.getElementsByClass("p-name").eq(0).text();
        //商品价格
        String price = element1.getElementsByClass("p-price").eq(0).text();

        System.out.println("标题:::"+ title);
        System.out.println("价格:::"+price);

    }

}

}
