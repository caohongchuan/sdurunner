package com.caohongchuan.sdurunner.exception;

public enum CommonEnum implements BaseErrorInfoInterface  {

    SUCCESS(200, "成功!");


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


    public String getErrormsg() {
        return errormsg;
    }


}
