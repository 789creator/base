package com.b2cshop.modules.im;

import com.b2cshop.modules.im.handler.IMEventHandler;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class ServerRunner implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(ServerRunner.class);
    //todo 抽取到配置文件里面或者某个配置类里面
    private String namespace = "im";

    private String agentNameSpace;

    private final SocketIOServer server;
    private final SocketIONamespace imSocketNameSpace;

    @Autowired
    public ServerRunner(SocketIOServer server) {
        this.server = server;
        imSocketNameSpace = server.addNamespace(namespace);
    }

    @Bean(name = "imNamespace")
    public SocketIONamespace getIMSocketIONameSpace(SocketIOServer server) {
        imSocketNameSpace.addListeners(new IMEventHandler(server));
        return imSocketNameSpace;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("SocketIOServer:" + server.getConfiguration().getHostname() + ":" + server.getConfiguration().getPort());
        server.start();
    }


}
