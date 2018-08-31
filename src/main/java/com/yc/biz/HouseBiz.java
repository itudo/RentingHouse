package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.House;
import com.yc.bean.JsonModel;
import com.yc.bean.PageBean;

public interface HouseBiz {
	/**
	 * 根据id查询某个房子的信息
	 * @param hb
	 * @return
	 */
	public House getHouseBean(House hb);
	
	public int addHosue(House hb);
	
	public int updateHouse(House hb);
	
	public int delHouse(int id);
	
	public int delHouse(List<Integer> ids);
	
	public JsonModel searchHouse(Map<String,Object> map);
	
	public PageBean searchHouseByPage(Map<String, Object> map);
}
