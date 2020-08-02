package com.caohongchuan.sdurunner.exception;

public enum CommonEnum implements BaseErrorInfoInterface  {

    SUCCESS(200, "sucess!"),

    USEREXITED(301, "user exited"),
    PASSWORDERROR(302, "password error"),
    USERUNEXITED(303, "user unexited"),

    USERUPDATEERROR(310, "user update error"),
    USERREGISTERERROR(311, "user insert error"),

    ATTENTIONERROR(320, "attention error"),
    CANCELATTENTIONERROR(321, "cancel attention error"),
    GETFANERROR(322, "get fan error"),
    GETFOCUSERROR(323, "get focus error"),
    GETFRIENDRANKERROR(324, "get friend rank error"),

    INSERTPOSTERROR(330, "insert post error"),
    GETPOSTERROR(331, "get post error"),
    UPDATEPOSTERROR(332, "update post error"),
    GETFRIENDPOSTERROR(333, "get friend post error"),
    GETRANDOMPOSTERROR(334, "get random post error"),

    ADDCOMMITERROR(340, "ad dcommit error"),
    DELETECOMMITERROR(341, "delete commit error"),
    ADDLIKEERROR(342, "add like error"),
    DELETELIKEERROR(343, "delete like error"),
    GETCOMMITERROR(344, "get commit error"),
    GETLIKEERROR(345, "get like error"),

    CANTCHANGEPOST(400, "can't change other post"),

    SERVERERROR(500, "server error");


    private int code;
    private String errormsg;

    CommonEnum(int code, String errormsg) {
        this.code = code;
        this.errormsg = errormsg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getErrormsg() {
        return errormsg;
    }


}
