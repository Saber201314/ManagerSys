package springDemo.Controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import springDemo.Service.SpringService;
import springDemo.domain.User;

@Controller
@RequestMapping("/cls")
public class springMvcController {	
	@Resource
	SpringService service;
	
	//host:8080/hello/mvc
	@RequestMapping("/holloMvc")
	public String helloMvc(Model model){
		List<User> listAll = service.listAll();
		List<User> listByName = service.listByName("ÀîËÄ");
		model.addAttribute("users", listAll);
		model.addAttribute("users2", listByName);
		return "index";
	}
	
	@RequestMapping("/getbody")
	@ResponseBody
	public String GetStr(){
		List<User> listAll = service.listAll();
		return JSON.toJSONString(listAll);
	}
	
	@RequestMapping("/Page01")
	public String GetPage1(){
		
		String pageName = "index";
		
		
		return pageName;
	}
}
