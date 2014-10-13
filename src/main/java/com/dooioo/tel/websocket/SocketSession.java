package com.dooioo.tel.websocket;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * Created by kuang on 14-10-13.
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
