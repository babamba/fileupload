package com.bit2016.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.fileupload.service.FileUploadService;

@Controller
@RequestMapping("")
public class FileUploadController {
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping( "/form" )
	public String form() {
		return "form";
	}
	
	@RequestMapping("/upload")
	public String upload(
			@RequestParam(value="email", required=true, defaultValue="") String email,
			@RequestParam(value="file1") MultipartFile file1,
			Model model
			){
		System.out.println(file1);
		System.out.println("email : " + email);
		String url1 = fileUploadService.restore(file1);
		model.addAttribute("url1" , url1);
		return "result";
	}


}
