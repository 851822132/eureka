package com.ysh.adminsecurity.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * Mybatis配置
 * @author Louis
 * @date Oct 29, 2018
 */
@Configuration
@MapperScan("com.ysh.adminsecurity.*.dao")	// 扫描DAO
public class MybatisConfig {
  @Autowired
  private DataSource dataSource;

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
    // 扫描Model
    sessionFactory.setTypeAliasesPackage("com.ysh.adminsecurity.*.model");
    
	PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    // 扫描映射文件
	sessionFactory.setMapperLocations(resolver.getResources("classpath*:**/mapping/*.xml"));
	
    return sessionFactory.getObject();
  }
}