package com.b2cshop.modules.im.handler;

import com.b2cshop.modules.im.message.ChatMessage;
import com.b2cshop.modules.im.message.ChatObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.List;


public class IMEventHandler {

    private Logger logger = LoggerFactory.getLogger(IMEventHandler.class);

    protected SocketIOServer server;

    @Autowired
    public IMEventHandler(SocketIOServer server) {
        this.server = server;
    }

    @OnConnect
    public void onConnect(SocketIOClient client) {
        logger.info("client:" + client.getHandshakeData().getUrl());
    }

    //添加@OnDisconnect事件，客户端断开连接时调用，刷新客户端信息  
    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {

    }

    //    @OnEvent(value = "")
//    public void onEvent(SocketIOClient client, AckRequest request, ChatObject chatObject) {
//        logger.info("onEvent");
//    }
    //消息接收入口，用于接受网站资源用户传入的 个人信息
//    @OnEvent(value = "new")
//    public void onEvent(SocketIOClient client, AckRequest request, Contacts contacts) {
//
//
//    }
//
//    //消息接收入口，坐席状态更新
//    @OnEvent(value = "agentstatus")
//    public void onEvent(SocketIOClient client, AckRequest request, AgentStatusMessage data) {
//        System.out.println(data.getMessage());
//    }
//
    //消息接收入口，收发消息，用户向坐席发送消息和 坐席向用户发送消息
    @OnEvent(value = "message")
    public void onEvent(SocketIOClient client, AckRequest request, ChatObject data) throws UnsupportedEncodingException {
        logger.info(data.toString());
        client.sendEvent("message",data);
    }
}  