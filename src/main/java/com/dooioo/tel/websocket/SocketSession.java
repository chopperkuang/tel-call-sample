package com.dooioo.tel.websocket;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * 因为只是1个人使用的demo
 * 这儿就只创建1个socket实例
 */

public class SocketSession {

    private static WebSocketSession webSocketSession;

    public static void setWebSocketSession(WebSocketSession webSocketSession) {
        SocketSession.webSocketSession = webSocketSession;
    }

    public static void sendMessage(String message) {
        try {
            webSocketSession.sendMessage(new TextMessage(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
