package com.than.chat;

import lombok.Data;

/**
 * @author Than
 * @package: com.than.chat
 * @className: ChatMessage
 * @description: 聊天消息实体
 * @date: 2023/10/15 21:39
 */

@Data
public class ChatMessage {
    private String username;
    private int type;
    private int targetType;
    private String targetName;

    private String massage;

    public ChatMessage(String username, int type, int targetType, String targetName, String massage) {
        this.username = username;
        this.type = type;
        this.targetType = targetType;
        this.targetName = targetName;
        this.massage = massage;
    }

    public ChatMessage() {

    }
}
