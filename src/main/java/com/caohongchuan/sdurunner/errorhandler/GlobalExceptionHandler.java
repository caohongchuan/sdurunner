package com.caohongchuan.sdurunner.errorhandler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> resultError(){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code" ,500);
        result.put("errormsg", "服务器处理异常");
        return result;
    }


}
