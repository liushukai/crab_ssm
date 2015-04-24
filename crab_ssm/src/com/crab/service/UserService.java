package com.crab.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crab.dao.UserMapper;
import com.crab.entity.Resource;
import com.crab.entity.Role;
import com.crab.entity.User;

@Service
public class UserService implements UserDetailsService
{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public UserDetails loadUserByUsername(String paramString) throws UsernameNotFoundException
	{
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.selectUserRoleResource("1");
		List<Role> listRoles = user.getRoles();
		
		List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
		
		for (Role role : listRoles)
		{
			List<Resource> listResource = role.getResources();
			for (Resource resource : listResource )
			{
				list.add(new SimpleGrantedAuthority(resource.getReskey()));
			}
		}
		sqlSession .close();
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getUserpassword(), true, true, true, true, list);
	}

}
