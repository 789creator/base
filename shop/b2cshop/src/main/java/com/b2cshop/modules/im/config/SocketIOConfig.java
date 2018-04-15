package com.b2cshop.modules.im.config;

import com.b2cshop.modules.im.listener.SocketIOAuthorizationListener;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;

import javax.annotation.PreDestroy;

@Configuration
public class SocketIOConfig {
    private Logger logger = LoggerFactory.getLogger(SocketIOConfig.class);

    @Value("${b2c.im.server.host}")
    private String host;

    @Value("${b2c.im.server.port}")
    private Integer port;

    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration configuration = new com.corundumstudio.socketio.Configuration();
        configuration.setHostname(host);
        configuration.setPort(port);
        configuration.setAuthorizationListener(new SocketIOAuthorizationListener());
        SocketIOServer server = new SocketIOServer(configuration);
        return server;
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketServer) {
        return new SpringAnnotationScanner(socketServer);
    }

}
