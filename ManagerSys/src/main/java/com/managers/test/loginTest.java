package com.managers.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.manager.entitys.crawlerUser;
import com.manager.services.LoginService;

/**
 * 测试类
 * @author Sabers
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:spring-base.xml"}) 
public class loginTest {

	@Resource
	LoginService loginService;
	
  	   
	@Test
	public void login(){
		
		loginService.loginRegex();
		System.out.println("loginTest");
	}
	
	/**
	 * 测试查询用户信息
	 */
	@Test
	public void findByName(){
		
		crawlerUser user = new crawlerUser();
		user.setUserName("zhang");
		List<crawlerUser> users = loginService.findByName(user);
		
		System.out.println(JSON.toJSON(users));
	}
}
