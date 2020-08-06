package com.encore.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductDAO;

@Repository
public class MyProductDAOImpl implements MyProductDAO{
	
	private final String ns = "ProductMapper.";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addProduct(MyProduct vo) throws Exception {
		sqlSession.insert(ns + "addProduct", vo);
	}

	@Override
	public List<MyProduct> findByProductName(String words) throws Exception {
		return sqlSession.selectList(ns + "findByProductName", words);
	}

	@Override
	public List<MyProduct> findProducts() throws Exception {
		return sqlSession.selectList(ns + "findProducts");
	}

}
