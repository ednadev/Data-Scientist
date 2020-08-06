package com.encore.spring.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.spring.domain.MyProduct;

public class MyBatisUnitTest {

	public static void main(String[] args) throws IOException {
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		//addProduct
		MyProduct vo = new MyProduct("드럼 세탁기", "삼성", 720000);
		System.out.println("디비 before :: " + vo.getId()); //0
		
		//session.insert("ProductMapper.addProduct", vo); //디비에 값 집어넣고 + id값 자동생성 + 그 값을 vo에 setting
		System.out.println("INSERT OK!!");
		System.out.println("디비 after :: " + vo.getId()); //1
		
		session.commit();
		
		System.out.println("====================================================");
		
		//findByProductName
		List<MyProduct> list = session.selectList("ProductMapper.findByProductName", "세탁기");
		for(MyProduct v : list) System.out.println(v);
		
		System.out.println("====================================================");
		
		//findProducts
		List<MyProduct> list2 = session.selectList("ProductMapper.findProducts");
		for(MyProduct v : list2) System.out.println(v.toString());
	}

}
