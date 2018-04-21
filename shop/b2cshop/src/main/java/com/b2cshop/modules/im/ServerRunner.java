package com.b2cshop.modules.im;

import com.b2cshop.modules.im.handler.IMEventHandler;
import com.b2cshop.modules.im.message.ChatObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
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
    private String namespace = "/imMessage";

    private String agentNameSpace;

    private final SocketIOServer server;
    private final SocketIONamespace imSocketNameSpace;

    @Autowired
    public ServerRunner(SocketIOServer server) {
        this.server = server;
        this.imSocketNameSpace = server.addNamespace(namespace);
//        imSocketNameSpace.addEventListener("message", ChatObject.class,new DataListener<ChatObject>(){
//            @Override
//            public void onData(SocketIOClient client, ChatObject data, AckRequest ackSender) throws Exception {
//                logger.info(data.toString());
//            }
//        });
//        server.addEventListener("ackevent1", ChatObject.class, new DataListener<ChatObject>() {
//
//            @Override
//            public void onData(SocketIOClient client, ChatObject data, AckRequest ackSender) throws Exception {
//                logger.info(data.toString());
//            }
//        });
    }

    @Bean
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
