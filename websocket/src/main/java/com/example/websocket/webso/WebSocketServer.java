package com.example.websocket.webso;



import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.*;

import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@ServerEndpoint(value = "/websocket/{id}", configurator = WebSocketConfig.class)
@Component
public class WebSocketServer {

    static Logger log = LoggerFactory.getLogger(WebSocketServer.class);
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    private static ConcurrentHashMap<String, WebSocketServer> webSocketSet = new ConcurrentHashMap<>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //指定的sid，具有唯一性，暫定為用戶id
    private String sid = "";

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(@PathParam("id") String id, Session session, EndpointConfig config) {
        //获取WebsocketConfig.java中配置的“sessionId”信息值
        String httpSessionId = (String) config.getUserProperties().get("sessionId");
        this.session = session;
        this.sid=id;


        webSocketSet.put(sid,this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("用戶"+sid+"加入！当前在线人数为" + getOnlineCount());
        try {
            sendMessage("Hello world");
        } catch (IOException e) {
            System.out.println("IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("收到来自窗口" + sid + "的信息:" + message);
        //群发消息
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     *
     */
    public  boolean sendtoUser(String message,String sendUserId) throws IOException {
        if(sendUserId==null){
            for (String key : webSocketSet.keySet()) {
                try {
                    webSocketSet.get(key).sendMessage(message);

                } catch (IOException e) {
                    e.printStackTrace();

                }
            }


        }else {
            if (webSocketSet.get(sendUserId) != null) {
                if(!sid.equals(sendUserId)){
                    log.info("未找到匹配用戶");
                    return false;
                }{
                    webSocketSet.get(sendUserId).sendMessage(message);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("消息發送成功");
                    return true;
                }
            } else {
                //如果用户不在线则返回不在线信息给自己
                log.info("未找到匹配用戶");
                return false;
            }
        }
        return true;
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
