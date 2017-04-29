package com.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.manager.entitys.User;


@MapperScan
public interface LoginDao {

	List<User> selectAll();
	
	List<User> findByName(@Param("user")User user );
}
