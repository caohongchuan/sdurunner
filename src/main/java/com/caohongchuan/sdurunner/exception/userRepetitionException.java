package com.caohongchuan.sdurunner.exception;

public class userRepetitionException implements BaseErrorInfoInterface{

    private int code;
    private String errormsg;

    public userRepetitionException(int code, String errormsg) {
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
