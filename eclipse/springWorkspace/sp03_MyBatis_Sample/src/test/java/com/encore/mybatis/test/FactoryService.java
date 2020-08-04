package com.encore.mybatis.test;
/*
 * SqlSessionFactory 하나 받아오는 로직을 따로 분리...
 */

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryService {
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(r);
		}catch(Exception e) {
			System.out.println(e);
		}
	}//static
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
