package com.crab.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crab.dao.UserMapper;
import com.crab.entity.Resource;
import com.crab.entity.Role;
import com.crab.entity.User;

@Service
public class AppSerivce
{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public String getName(String name)
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.selectByPrimaryKey(1);
		
		user = userMapper.selectUserRoleResource("1");
		List<Role> listRoles = user.getRoles();
		for (Role role : listRoles)
		{
			System.out.println (role.getName());
			List<Resource> listResource = role.getResources();
			for (Resource resource : listResource )
			{
				System.out.println (resource.getResurl());
			}
		}
		
		return "=========" + user.getUsername();
	}
}
