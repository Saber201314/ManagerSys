package springDemo.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import springDemo.dao.UserMapper;
import springDemo.domain.User;

@Service
public class SpringService {
	@Resource
	UserMapper mapper;
	
	public String hello(){
		return "i am service ";
	}
	public List<User> listAll(){
		return mapper.selectAll();
	}
	
	public List<User> listByName(String name){
		User user=new User();
		user.setName(name);
		List<User> findByName=null;
		try {
			findByName = mapper.findByName(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return findByName;
	}
}
