package com.than.base;

/**
 * <P>结果码类</P>
 * @author Than
 */
public class Code {

    /**
     * 请求正常
     */
    public static final int OK = 200;
    /**
     * 错误
     */
    public static final int ERROR = 400;
    /**
     * 请求失败
     */
    public static final int FAIL=300;



    /*消息类型*/

    public static final int CONNECT=1;
    public static final int DISCONNECT = 2;
    public static final int CHAT_MESSAGE = 3;
    public static final int CHAT_ERROR = 0;


    /*聊天接收者*/
    public static final int GROUP_MSG = 4;
    public static final int GROUP_AT = 5;
    public static final int PERSON = 6;

}
