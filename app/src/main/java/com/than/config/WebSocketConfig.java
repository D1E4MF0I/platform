package com.than.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author Than
 * @package: com.than.config
 * @className: WebSocketConfig
 * @description: 聊天套接字设置
 * @date: 2023/10/15 21:16
 */

@Configuration
public class WebSocketConfig{
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
