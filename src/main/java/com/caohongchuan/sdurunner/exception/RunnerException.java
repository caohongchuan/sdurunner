package com.caohongchuan.sdurunner.exception;

public class RunnerException extends RuntimeException{

    private static final long serialVersionUID=1L;

    protected int code;
    protected String errormsg;

    public RunnerException(){
        super();
    }

    public RunnerException(BaseErrorInfoInterface bei){
        code = bei.getCode();
        errormsg = bei.getErrormsg();
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
