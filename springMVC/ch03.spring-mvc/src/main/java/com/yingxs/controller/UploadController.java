package com.yingxs.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.yingxs.domain.User;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@RequestMapping("test1")
	public String test1(HttpServletRequest request,User user,MultipartFile headIcon) throws Exception, IOException {
		System.out.println(user);
		
		//保存文件
		headIcon.transferTo(new File("d:/"+headIcon.getOriginalFilename()));
		return "success";
		
	}

}
