//package com.example.websocket.webso;
//
//import com.example.websocket.webso.WebManger;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//
////loadOnStartup标记为Servlet不是为了其被访问，而是为了便于伴随Tomcat一起启动
//@WebServlet(urlPatterns ="/MyThread",loadOnStartup=1)
//public class MyThread extends HttpServlet implements Runnable{
//    public void init(ServletConfig config){
//        new Thread(this).start();
//    }
//
//    @Override
//    public void run() {
//        int price=1000;
//        int count=1;
//        while (true) {
//            try {
//                Thread.sleep(2000);
//                float random = 1+(float) (Math.random()-0.5);
//
//                count= WebManger.getTotal();
//                if (count==0) {
//                    count=1;
//                }
//                //随着人数改变价格
//                price=(int)(random*price*count);
//                //格式化字符串
//                String messageFormat = "{\"price\":\"%d\",\"total\":%d}";
//                String message = String.format(messageFormat, price,count);
//                price=price/count;
//                WebManger.broadCast(message);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//}
