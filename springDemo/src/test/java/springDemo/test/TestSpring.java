package springDemo.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import springDemo.Service.SpringService;
import springDemo.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:spring-base.xml"}) 
public class TestSpring extends AbstractJUnit4SpringContextTests {
	
	@Resource 
	SpringService springService;  
	
    @Test
    public void a(){
    	List<User> listAll = springService.listAll();
    	System.out.println(JSON.toJSONString(listAll));
    }
    
}
