package com.encore.mybatis.test;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.mybatis.vo.MySawon;

/*
 * mysawon 테이블에 있는 모든 사원의 정보를 출력하는 코드를 작성
 */
public class SimpleMyBatisAppTest2 {

	public static void main(String[] args) {
		try {
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
			SqlSession session = factory.openSession();
			
			System.out.println("=============================================");
			
			/* SqlSession
			 * 
			 * query  statement                    execute method
			 * INSERT INTO ------------------------ insert()
			 * DELETE FROM ------------------------ delete()
			 * UPDATE table ----------------------- update()
			 * SELECT all ------------------------- List selectList()
			 * SELECT one ------------------------- Object selectOne()
			 */
			List<MySawon> list = session.selectList("mysawonMapper.sawonList");
			for(MySawon vo: list) {
				System.out.println(vo.getId() + ", " + vo.getName() + ", " + vo.getHiredate());
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
