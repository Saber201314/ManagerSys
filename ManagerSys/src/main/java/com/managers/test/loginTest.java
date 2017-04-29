package com.managers.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.manager.controllers.LoginController;
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
}
