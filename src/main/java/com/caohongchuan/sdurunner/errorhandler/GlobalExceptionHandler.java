package com.caohongchuan.sdurunner.errorhandler;


import com.caohongchuan.sdurunner.exception.CommonEnum;
import com.caohongchuan.sdurunner.exception.RunnerException;
import com.caohongchuan.sdurunner.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;




@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result resultError(){
        Result result = new Result(CommonEnum.SERVERERROR);
        return result;
    }

    @ExceptionHandler(RunnerException.class)
    @ResponseBody
    public Result runnerError(RunnerException re){
        Result result = new Result(re.getCode(), re.getErrormsg());
        return result;
    }

}
