package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.House;
import com.yc.bean.JsonModel;
import com.yc.bean.PageBean;
import com.yc.biz.HouseBiz;
import com.yc.dao.BaseDao;

@Service
public class HouseBizImpl implements HouseBiz {
	@Resource(name="baseDaoMybatisImpl")
	private BaseDao<House> baseDao;
	
	@Override
	public House getHouseBean(House hb) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", hb.getId()+"");
		House house = this.baseDao.findOne(House.class, "findHouseCondition", map);
		return house;
	}

	@Override
	public int addHosue(House hb) {
			return baseDao.save(hb,"saveHouse");
	}

	@Override
	public int updateHouse(House hb) {
			return baseDao.update(hb,"updateHouse");
	}

	@Override
	public int  delHouse(int id) {
			return baseDao.del(House.class, id+"","delSingleHouse");
	}

	@Override
	public int delHouse(List<Integer> ids) {
		return baseDao.del(House.class, ids, "delMutilHouse");
	}

	@Override
	public JsonModel<House> searchHouse(Map<String, Object> map) {
		List<House> list = baseDao.findAll(House.class,"findHouseCondition",map);
		int total = baseDao.getCount(House.class,map,"findHouseConditionCount");
		JsonModel<House> jsonModel = new JsonModel<House>();
		jsonModel.setRows(list);
		//jsonModel.setPages(Integer.parseInt(map.get("pages").toString()));
		//jsonModel.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		return jsonModel;
	}
	
	@Override
	public PageBean<House> searchHouseByPage(Map<String, Object> map) {
		List<House> list = baseDao.findAll(House.class,"findHouseCondition",map);
		int total = baseDao.getCount(House.class,map,"findHouseConditionCount");
		PageBean<House> pb = new PageBean<House>();
		pb.setList(list);
		pb.setTotal(total);
		if(map.get("pages")!=null&&!"".equals(map.get("pages").toString())) {
			pb.setPages(Integer.parseInt(map.get("pages").toString()));
		}
		pb.setTotalpages(total/pb.getPagesize()==0?total/pb.getPagesize():total/pb.getPagesize()+1);
		return pb;
	}

}
