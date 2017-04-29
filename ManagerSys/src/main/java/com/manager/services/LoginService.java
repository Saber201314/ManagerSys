package com.manager.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.manager.dao.LoginDao;
import com.manager.entitys.User;

@Service
public class LoginService {

	@Resource
	LoginDao logindao;
	
	/**
	 * 登录验证
	 * @return 是否登录成功
	 */
	public List<User> loginRegex(){
		
		List<User> users = logindao.selectAll();
		System.out.println(JSON.toJSON(users));
		System.out.println("Login Regex");
		
		return users;
	}
	
}
