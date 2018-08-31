package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.yc.bean.District;
import com.yc.bean.Street;
import com.yc.bean.User;
import com.yc.biz.DistrictBiz;
import com.yc.dao.BaseDao;

@Service
public class DistrictBizImpl implements DistrictBiz {
	@Resource(name="baseDaoMybatisImpl")
	private BaseDao<District> baseDao;

	@Override
	public List<District> getDistrictList() {
		List<District> districts = null;
		districts = baseDao.findAll(District.class, "findAllDistrict");
		return districts;
	}
 
	/*@Override
	public List<District> getDistrictList() {
		List<District> districts = null;
		districts = baseDao.findAll(District.class, "findAllDistrict");
		return districts; 
	}*/

	
	
}
