package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.District;
import com.yc.bean.Street;
import com.yc.biz.StreetBiz;
import com.yc.dao.BaseDao;
@Service
public class StreetBizImpl implements StreetBiz {
	
	@Resource(name="baseDaoMybatisImpl")
	private BaseDao<Street> baseDao;
	
	@Override
	public List<Street> getStreetByDistrictId(Integer did) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("did", did+"");
		List<Street> streets = baseDao.findAll(Street.class, "getStreetDistrict", map);
		return streets;
	}
}
