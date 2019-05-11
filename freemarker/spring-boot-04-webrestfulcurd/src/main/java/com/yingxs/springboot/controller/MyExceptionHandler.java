package com.yingxs.springboot.controller;

import com.yingxs.springboot.exception.UserNotException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {


//    // 1.浏览器和客户端拿到的都是json数据
//    @ResponseBody
//    @ExceptionHandler(UserNotException.class)
//    public Map<String,Object> handleException(Exception e){
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//
//    }

    // 2.自适应效果，浏览器和客户端都能得到页面和json数据，但客户端的json非定制
    @ExceptionHandler(UserNotException.class)
    public String handleException(Exception e, HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<>();
        // 传入我们自己的错误状态码 4xx ,5xx
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
        map.put("message",e.getMessage());

        request.setAttribute("ext",map);
        return "forward:/error";

    }















}
