package com.b2cshop.modules.im.listener;

import com.corundumstudio.socketio.AuthorizationListener;
import com.corundumstudio.socketio.HandshakeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 认证授权 监听
 */
public class SocketIOAuthorizationListener implements AuthorizationListener{
    private Logger logger = LoggerFactory.getLogger(SocketIOAuthorizationListener.class);
    @Override
    public boolean isAuthorized(HandshakeData data) {
        logger.debug("---------SocketIOAuthorizationListener-------------");
        return true;
    }
}
