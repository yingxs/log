package com.yingxs.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
// 给容器中我们自定义的ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        // 我们的异常处理器携带的数据
        Map<String,Object> ext = (Map<String,Object>)webRequest.getAttribute("ext",0);
        map.put("ext",ext);
        map.put("company","yingxs");
        return map;
    }
}
