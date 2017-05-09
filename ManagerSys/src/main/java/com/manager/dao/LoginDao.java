package com.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.manager.entitys.crawlerUser;


@MapperScan
public interface LoginDao {

	/**
	 * 查询所有用户
	 * @return
	 */
	List<crawlerUser> selectAll();
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	List<crawlerUser> findByName(@Param("user")crawlerUser user );
}
