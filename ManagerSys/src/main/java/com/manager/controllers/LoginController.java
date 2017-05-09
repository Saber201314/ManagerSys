package com.manager.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.manager.entitys.crawlerUser;
import com.manager.services.LoginService;

@Controller
@RequestMapping()
public class LoginController {

	@Resource
	LoginService loginservice = null;
	
	/**
	 * 用戶登錄驗證
	 * @param model
	 * @return
	 */
	@RequestMapping("/home") 
	public String login(HttpServletRequest  request,Model model){
		String page = "home";
		String userName =request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		System.out.println(userName + "\t" + userPwd);
		
		crawlerUser user = new crawlerUser();
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		
		//查詢用戶信息
		List<crawlerUser> users = loginservice.findByName(user);
		if(users.size() > 0)
		{
			model.addAttribute("users",users);
			return "home"; 
		}else
		{
			return "index";
		}
	}
	
	/**
	 * 接口API
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/loginApi")
	public String loginApi()
	{
		List<crawlerUser> users = loginservice.loginRegex();
		String userMsg = JSON.toJSONString(users);
		
		return userMsg;
	}
}
