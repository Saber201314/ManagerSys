package springDemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import springDemo.domain.User;

@MapperScan
public interface UserMapper {
	List<User> selectAll();
	
	List<User> findByName(@Param("user")User user );
}
