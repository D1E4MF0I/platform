package com.than.controller.chat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.than.base.Code;
import com.than.chat.ChatMessage;
import jakarta.websocket.Session;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Than
 * @package: com.than.controller.chat
 * @className: ChatHandler
 * @description: 处理聊天消息转发，管理在线用户等
 * @date: 2023/10/17 16:20
 */

@Component
public class ChatHandler {

    public static final Map<String, Session> sessionMap = new ConcurrentHashMap<>();
    private final ObjectMapper mapper=new ObjectMapper();


    /**
     * 用于添加在线user
     *
     * @param userName 用户名
     * @param session user session
     * @return 当前在线user数量
     */
    public int addUser(String userName,Session session){
        Session s = sessionMap.computeIfAbsent(userName, k -> session);
        if(s==null){
            // TODO: 2023/10/17 判空处理
        }
        return  sessionMap.size();
    }

    public int removeUser(String userName,Session session){
        sessionMap.computeIfPresent(userName, (k, v) -> null);
        return sessionMap.size();
    }

    /**
     * 发送聊天消息
     * @param message  消息json
     * @param session  发送给谁
     * @param username 发送人
     */
    public void sendChatMsg(String message, Session session, String username) {
        ChatMessage msg = convertEntities(message);

        if(!username.equals(msg.getUsername())){
            return;
        }

        if (msg.getType() == Code.CHAT_MESSAGE) {
            sendToCorrect(msg, message, session);
        }
    }


    /**
     * 发送连接信息（连接和断开连接）
     * @param session 发送人
     * @param message 消息json
     */
    public void sendConnectMsg(Session session, ChatMessage message){
        String Json = convertEntities(message);
        sendAllMessage(Json, session);
    }



    private void sendToCorrect(ChatMessage msg, String message, Session session) {
        if (msg.getTargetType() == Code.GROUP_MSG) {
            sendAllMessage(message, sessionMap.get(msg.getUsername()));
        } else if (msg.getTargetType() == Code.PERSON) {
            sendMessage(message, session);
        }
    }

    private ChatMessage convertEntities(String message) {
        try {
            return mapper.readValue(message, ChatMessage.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private String convertEntities(ChatMessage message) {
        try {
            return mapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    private void sendMessage(String message, Session toSession) {
        try {
            toSession.getBasicRemote().sendText(message);
        } catch (Exception e) {
            //log.error("服务端发送消息给客户端失败", e);
        }
    }

    /**
     * 服务端发送消息给所有客户端
     */
    private void sendAllMessage(String message, Session s) {
        for (Session session : sessionMap.values()) {
            if (s != session) {
                sendMessage(message, session);
            }
        }
    }
}
