package com.caohongchuan.sdurunner.result;


import com.caohongchuan.sdurunner.exception.BaseErrorInfoInterface;
import com.caohongchuan.sdurunner.exception.CommonEnum;

/**
 * 状态码返回 结果
 * @author caohongchuan
 * @version 1.0
 */
public class Result {

    private int code;

    private String errormsg;

    public Result(int code, String errormsg) {
        this.code = code;
        this.errormsg = errormsg;
    }

    public Result(BaseErrorInfoInterface baseErrorInfoInterface){
        this.code = baseErrorInfoInterface.getCode();
        this.errormsg = baseErrorInfoInterface.getErrormsg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }
}
