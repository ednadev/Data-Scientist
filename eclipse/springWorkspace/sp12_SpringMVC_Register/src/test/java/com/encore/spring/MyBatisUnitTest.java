package com.encore.spring;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.domain.Member;

public class MyBatisUnitTest {

	@Test
	public void unit() throws Exception {
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
//		session.insert("Member.registerMember", new Member("mybatis", "1234", "마이바티스", "서초동"));
//		session.commit();
		
//		List<Member> list = session.selectList("Member.showAllMember");
//		for(Member vo : list) System.out.println(vo);
		
//		Member vo = session.selectOne("Member.findByIdMember", "mybatis");
//		System.out.println(vo);
		
//		Member vo = session.selectOne("Member.login", new Member("mybatis", "1234"));
//		System.out.println(vo);
		
//		session.update("Member.updateMember", new Member("mybatis", "1111", "마이", "서현동"));
//		session.commit();
		
		String check = session.selectOne("Member.idExist", "mybati"); //없으면 "null"
		System.out.println(check);
		
	}
	
}
