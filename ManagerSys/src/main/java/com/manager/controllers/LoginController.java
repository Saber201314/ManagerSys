package com.manager.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.manager.entitys.User;
import com.manager.services.LoginService;

@Controller
@RequestMapping()
public class LoginController {

	@Resource
	LoginService loginservice = null;
	
	@RequestMapping("/login") 
	public String login(Model model){
		System.out.println("LoginController - Login");
		String page = "home";
		
		List<User> users = loginservice.loginRegex();
		model.addAttribute("users",users);
		return "home"; 
	}
	
	/**
	 * 返回json数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/loginApi")
	public String loginApi(){
		
		List<User> users = loginservice.loginRegex();
		String userMsg = JSON.toJSONString(users);
		
		return userMsg;
	}
}
