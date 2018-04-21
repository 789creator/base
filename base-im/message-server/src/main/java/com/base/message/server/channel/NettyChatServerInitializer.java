/*
 * Copyright © 2013-2016 BLT, Co., Ltd. All Rights Reserved.
 */

package com.base.message.server.channel;

import com.base.message.server.manager.HandlerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.base.message.common.code.PacketDecoder;
import com.base.message.common.code.PacketEncoder;
import com.base.message.server.handler.MessageServerHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * 初始化socket
 * 
 * @author 袁贵
 * @version 1.0
 * @since 1.0
 */
@Deprecated
@Component("NettyChatServerInitializer")
public class NettyChatServerInitializer extends ChannelInitializer<SocketChannel> {

    @Autowired
    private HandlerManager handlerManager;
    
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("framer", new LengthFieldBasedFrameDecoder(400 * 1024, 0, 4, -4, 0));
        pipeline.addLast("decoder", new PacketDecoder());
        pipeline.addLast("encoder", new PacketEncoder());
        pipeline.addLast(new LoggingHandler(LogLevel.DEBUG));
        pipeline.addLast("handler", new MessageServerHandler(handlerManager));
    }

}
