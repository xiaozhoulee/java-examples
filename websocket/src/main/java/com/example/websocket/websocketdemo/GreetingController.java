//package com.example.websocket.websocketdemo;
//
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//import sun.plugin2.message.Message;
//
//@Controller
//public class GreetingController {
//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public Message greeting(Message message)throws Exception{
//        return message;
//    }
//    public class Message{
//    private String name;
//    private String content;
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getContent() {
//            return content;
//        }
//
//        public void setContent(String content) {
//            this.content = content;
//        }
//    }
//}
