package com.yc.biz.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.User;
import com.yc.biz.UserBiz;
import com.yc.dao.BaseDao;

@Transactional(readOnly = false, propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT)//默认事务，在类上配置的事务机制在每个方法上都起作用
@Service
public class UserBizImpl implements UserBiz {
	@Resource(name="baseDaoMybatisImpl")
	private BaseDao<User> baseDao;
	
	@Override
	public int register(User user) {
		return baseDao.save(user, "saveUser");
	}

	@Override
	public int  valiate(User user) {
		user =   baseDao.findOne(user, "isUserExists");
		if(user!=null) {
			return 1;
		}
		return 0;
	}

	@Override
	public User getUserById(Integer id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		return  baseDao.findOne(User.class, "getUserById", map);
	}

	@Override
	public User login(User user) {
		User u =  baseDao.findOne(user, "getUserByLogin");
		return u;
	}

}