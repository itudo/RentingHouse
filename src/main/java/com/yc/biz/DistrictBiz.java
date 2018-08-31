package com.yc.biz;

import java.util.List;

import com.yc.bean.District;
import com.yc.bean.Street;

public interface DistrictBiz {
	/**
	  * 查询所有的区
	  * @return
	  */
	public List<District> getDistrictList();
	
}
