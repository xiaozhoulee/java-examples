//package com.example.websocket.websocketdemo;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Component
//public class WebSocketComponent {
//    @Autowired
//    private SimpMessagingTemplate simpMessageSendingOperations;//消息发送模板
//
////    @Scheduled(fixedRate = 1000 * 30)//
//    public void sendMessage() {
//        simpMessageSendingOperations.convertAndSend("/topic/ip", "我是从服务器来的消息!");//将消息推送给‘、topic/ip’的客户端
//    }
//
//}