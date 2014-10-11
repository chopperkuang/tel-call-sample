package com.dooioo.tel.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

public class WebSocketConfig{

    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new CallHandler(), "/");
    }
}
