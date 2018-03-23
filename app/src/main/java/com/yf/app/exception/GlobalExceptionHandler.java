package com.yf.app.exception;

import com.yf.lib.vo.RespVO;
import com.yf.lib.vo.RespVOBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler  {


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public RespVO notFountException(Exception ex, HttpServletRequest request){
        log.info("requestUrl:{}",request.getRequestURI());
        log.error(ex.getMessage(),ex);
        return RespVOBuilder.failure();
    }

    /**
     * 默认异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public RespVO exception(Exception ex,HttpServletRequest request) {
        log.info("requestUrl:{}",request.getRequestURI());
        log.error(ex.getMessage(), ex);
        return RespVOBuilder.failure();
    }



}
