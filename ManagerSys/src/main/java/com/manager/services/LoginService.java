package com.manager.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.manager.dao.LoginDao;
import com.manager.entitys.crawlerUser;

@Service
public class LoginService {

	@Resource
	LoginDao logindao;
	
	/**
	 * 查询用户信息
	 * @return 用户信息集合
	 */
	public List<crawlerUser> loginRegex(){
		
		List<crawlerUser> users = logindao.selectAll();
		
		return users;
	}
	
	/**
	 * 根据名称查询用户信息
	 * @param user
	 * @return
	 */
	public List<crawlerUser> findByName(crawlerUser user){
		
		return logindao.findByName(user);
	}
}
