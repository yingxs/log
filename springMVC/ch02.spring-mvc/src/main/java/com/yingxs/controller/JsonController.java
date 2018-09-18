package com.yingxs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yingxs.domain.User;

@Controller
@RequestMapping("/json")
public class JsonController {

	//@RequestBody：代表接收页面的json数据
	//@@ResponseBody：代表Controller返回json数据
	@RequestMapping("/test1")
	@ResponseBody
	public User test1(@RequestBody User user) {
		System.out.println(user);
		return user;
	}
}
