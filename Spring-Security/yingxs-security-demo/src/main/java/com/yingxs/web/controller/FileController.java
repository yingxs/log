package com.yingxs.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yingxs.dto.FileInfo;

@RestController
@RequestMapping("/file")
public class FileController {
	
	String folder = "D:\\github\\javaEE_log\\Spring-Security\\yingxs-security-demo\\src\\main\\java\\com\\yingxs\\web\\controller";
	
	@PostMapping
	public FileInfo upload(MultipartFile logo) throws   Exception {
		
		System.out.println(logo.getName());
		System.out.println(logo.getOriginalFilename());
		System.out.println(logo.getSize());
		
		File localFile = new File(folder,new Date().getTime()+".txt");
		logo.transferTo(localFile);
		
		
		return new FileInfo(localFile.getAbsolutePath());
		
	}
	
	
	@GetMapping("/{id}")
	public void download(@PathVariable String id, HttpServletRequest request,HttpServletResponse response) throws Exception {
	
		try(
				FileInputStream inputStream = new FileInputStream(new File(folder,id+".txt"));
				OutputStream outputStream = response.getOutputStream();
		){
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=test.txt");
			IOUtils.copy(inputStream, outputStream);
			outputStream.flush();
			
		}
		
		
		
	}
	

}
