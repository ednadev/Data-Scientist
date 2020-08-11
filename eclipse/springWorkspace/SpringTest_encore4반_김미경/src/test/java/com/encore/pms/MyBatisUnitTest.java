package com.encore.pms;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;

public class MyBatisUnitTest {
	
	@Test
	public void unit() throws Exception {
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
//		session.insert("Phone.insert", new Phone("S105G","겔럭시 S10 5G",1397000,"10"));
//		session.insert("Phone.insert", new Phone("V50SQ","LG V50S ThinQ",1199000,"20"));
//		session.commit();
		
//		List<String> list = new ArrayList<String>();
//		list.add("S105G");
//		list.add("V50SQ");
//		session.delete("Phone.delete", list);
//		session.commit();
		
//		Phone phone = session.selectOne("Phone.select", new Phone("S105G","겔럭시 S10 5G",1397000,"10"));
//		System.out.println(phone);
		
//		List<Phone> list = session.selectList("Phone.selectAll");
//		for(Phone vo : list) System.out.println(vo);
		
		UserInfo userInfo = session.selectOne("Phone.selectUser", new UserInfo("admin", "admin"));	
		System.out.println(userInfo);
	}
}
