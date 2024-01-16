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

    /*数据库处理相关*/
    public static final int DATABASE_SUCCESS = 50000;
    public static final int DATABASE_ERROR = 50001;

    /*数据库帖子处理相关*/
    public static final int DATABASE_POST_INSERT_SUCCESS = 50002;
    public static final int DATABASE_POST_INSERT_ERROR = 50003;
    public static final int DATABASE_POST_UPDATE_SUCCESS = 50004;
    public static final int DATABASE_POST_UPDATE_ERROR = 50005;
    public static final int DATABASE_POST_SELECT_SUCCESS = 50006;
    public static final int DATABASE_POST_SELECT_ERROR = 50007;
    public static final int DATABASE_POST_DELETE_SUCCESS = 50008;
    public static final int DATABASE_POST_DELETE_ERROR = 50009;

    /*数据库用户处理相关*/
    public static final int DATABASE_USER_INSERT_SUCCESS = 50010;
    public static final int DATABASE_USER_INSERT_ERROR = 50011;
    public static final int DATABASE_USER_UPDATE_SUCCESS = 50012;
    public static final int DATABASE_USER_UPDATE_ERROR = 50013;
    public static final int DATABASE_USER_SELECT_SUCCESS = 50014;
    public static final int DATABASE_USER_SELECT_ERROR = 50015;
    public static final int DATABASE_USER_DELETE_SUCCESS = 50016;
    public static final int DATABASE_USER_DELETE_ERROR = 50017;
}
