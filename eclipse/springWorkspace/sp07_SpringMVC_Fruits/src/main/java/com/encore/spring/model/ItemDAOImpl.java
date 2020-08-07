package com.encore.spring.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Item;
import com.encore.spring.model.ItemDAO;

@Repository
public class ItemDAOImpl implements ItemDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Item> getItemList() {
		return sqlSession.selectList("ItemMapper.getItemList");
	}

	@Override
	public Item getItem(Integer itemid) {
		return sqlSession.selectOne("ItemMapper.getItemList", itemid);
	}

}
