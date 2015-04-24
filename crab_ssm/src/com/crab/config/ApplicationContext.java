package com.crab.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Controller;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ComponentScan(basePackages = "com.crab", excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = { Controller.class }) })
public class ApplicationContext
{
	private static final Logger logger = LogManager.getLogger(ApplicationContext.class);
	/**
	 * 配置数据源
	 * @return
	 */
	@Bean(name="druidDataSource",initMethod="init",destroyMethod="close")
	public DruidDataSource druidDataSource()
	{
		logger.info("================  start druidDataSource =====================");
		DruidDataSource dds = new DruidDataSource();
		dds.setDriverClassName("com.mysql.jdbc.Driver");
		dds.setUrl("jdbc:mysql://localhost:3306/ssm3?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		dds.setUsername("root");
		dds.setPassword("");
		dds.setInitialSize(5);
		dds.setMaxActive(10);
		dds.setMinIdle(5);
		dds.setMaxWait(60000);
		dds.setRemoveAbandoned(true);
		dds.setRemoveAbandonedTimeout(180);
		dds.setTimeBetweenEvictionRunsMillis(60000);
		dds.setMinEvictableIdleTimeMillis(300000);
		dds.setValidationQuery("SELECT 1");
		dds.setTestWhileIdle(true);
		dds.setTestOnBorrow(false);
		dds.setTestOnReturn(false);
		dds.setPoolPreparedStatements(true);
		dds.setMaxPoolPreparedStatementPerConnectionSize(50);
		try
		{
			dds.setFilters("stat");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			logger.error("设置 filter = stat 错误");
		}
		return dds;
	}
	
	@Bean(name="sqlSessionFactory")
	@Autowired 
	public SqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("druidDataSource") DataSource druidDataSource)
	{
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(druidDataSource);
		
		//DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
		
		//sqlSessionFactoryBean.setMapperLocations(defaultResourceLoader.getResource("classpath:com/arch/dao/*/*.xml"));
		//<property name="dataSource" ref="dataSource"></property>
		//	    <property name="configLocation" value="classpath:mybatis/mybatis-config.xml"></property>
//	    <!-- mybatis配置文件自动扫描路径  -->
//	    <property name="mapperLocations" value="classpath:com/arch/dao/*/*.xml"></property>
		
		DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
//		Resource resource = defaultResourceLoader.getResource("classpath:com/crab/entity/UserMapper.xml");
//		Resource[] resources = {resource};
//		sqlSessionFactoryBean.setMapperLocations(resources);
		
		
		sqlSessionFactoryBean.setConfigLocation(defaultResourceLoader.getResource("classpath:mybatis-config.xml"));
		
		return sqlSessionFactoryBean;
		
		
	}
	   
	@Bean(name="sqlSessionTemplate")
	@Autowired 
	public SqlSessionTemplate SqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception
	{
		return new SqlSessionTemplate(sqlSessionFactoryBean.getObject());
	}
	
	
	
}
