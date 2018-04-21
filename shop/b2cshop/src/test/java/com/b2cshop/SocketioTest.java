package com.b2cshop;

import com.b2cshop.modules.im.message.ChatObject;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import io.socket.engineio.client.transports.WebSocket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;
import java.util.Calendar;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SocketioTest {

    private Logger logger = LoggerFactory.getLogger(SocketioTest.class);

    @Test
    public void sendMeassage() throws URISyntaxException, InterruptedException {
        Socket socket = IO.socket("http://192.168.12.103:9092/imMessage");
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... objects) {
                logger.info("-------EVENT_CONNECT------");
                ChatObject chatObject = new ChatObject();
                chatObject.setUserName("test");
                chatObject.setMessage("test"+ Calendar.getInstance().getTime().toString());
                socket.emit("message",chatObject);
            }
        }).on("message", new Emitter.Listener() {
            @Override
            public void call(Object... objects) {
                logger.info("-------message------");
            }
        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... objects) {
                logger.info("-------EVENT_DISCONNECT------");
            }
        });
        socket.connect();

//        Thread.sleep(10000);

        logger.info("---------------------");
    }

    public void sendMessage2(){

    }
}
