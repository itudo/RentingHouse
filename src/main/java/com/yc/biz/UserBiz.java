package com.yc.biz;

import java.util.List;

import com.yc.bean.District;
import com.yc.bean.Street;
import com.yc.bean.User;

public interface UserBiz {
	 /**
	  * 注册用户
	  * @param user
	  * @return
	  */
	public int register(User user);
	
	/**
	 * 用户名是否存在
	 * @param user
	 * @return
	 */
	public int valiate(User user);
	
	/**
	 * 根据id查用户
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public User login(User user);
}
