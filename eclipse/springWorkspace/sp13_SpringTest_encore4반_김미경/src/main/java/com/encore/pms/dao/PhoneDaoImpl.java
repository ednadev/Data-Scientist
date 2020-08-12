package com.encore.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;

@Repository
public class PhoneDaoImpl implements IPhoneDAO{
	
	@Autowired
	private SqlSession sqlSession;

	public int insert(Phone phone) {
		return sqlSession.insert("Phone.insert", phone);
	}

	public int delete(List<String> list) {
		return sqlSession.delete("Phone.delete", list);
	}

	public Phone select(Phone phone) {
		return sqlSession.selectOne("Phone.select", phone);
	}

	public List<Phone> select() {
		return sqlSession.selectList("Phone.selectAll");
	}

	public UserInfo select(UserInfo user) {
		return sqlSession.selectOne("Phone.selectUser", user);	
	}
	
}
