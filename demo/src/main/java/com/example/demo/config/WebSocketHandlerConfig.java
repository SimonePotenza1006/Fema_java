package com.example.demo.config;

import com.example.demo.websocket.MyWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketHandlerConfig implements WebSocketConfigurer {

    private final MyWebSocketHandler myWebSocketHandler;

    public WebSocketHandlerConfig(MyWebSocketHandler myWebSocketHandler) {
        this.myWebSocketHandler = myWebSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // Configura il percorso "/ws" per le connessioni WebSocket
        registry.addHandler(myWebSocketHandler, "/ws").setAllowedOrigins("*");
    }
}
