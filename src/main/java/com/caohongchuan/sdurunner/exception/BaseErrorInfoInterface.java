package com.caohongchuan.sdurunner.exception;

public interface BaseErrorInfoInterface {
    /**
     * Wrong code
     * @return wrong code
     */
    int getCode();

    /**
     * error message
     * @return error message
     */
    String getErrormsg();
}
