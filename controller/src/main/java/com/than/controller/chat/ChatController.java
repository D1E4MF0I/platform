package com.than.controller.chat;

import com.than.base.Code;
import com.than.chat.ChatMessage;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Controller;

/**
 * @author Than
 * @package: com.than.controller.chat
 * @className: ChatController
 * @description: 私人聊天，群聊控制层
 * @date: 2023/10/15 21:11
 */
@Controller
@ServerEndpoint("/platform_chat/{username}")
public class ChatController {

    private final ChatHandler handler=new ChatHandler();


    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username){
        handler.addUser(username,session);
        ChatMessage message = new ChatMessage(username, Code.CONNECT, Code.GROUP_MSG, "", username + " 已经上线!");
        handler.sendConnectMsg(session,message);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session, @PathParam("username") String username){
        handler.removeUser(username,session);
        ChatMessage message = new ChatMessage(username, Code.DISCONNECT, Code.GROUP_MSG, "", username + " 已经下线!");
        handler.sendConnectMsg(session,message);
    }

    /**
     * 收到客户端消息后调用的方法
     * 后台收到客户端发送过来的消息
     * onMessage 是一个消息的中转站
     * 接受 浏览器端 socket.send 发送过来的 json数据
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("username") String username) {
        handler.sendChatMsg(message,session,username);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        throw new RuntimeException(error);
    }

}
