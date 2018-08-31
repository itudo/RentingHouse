package com.yc.biz;

import java.util.List;

import com.yc.bean.Street;

public interface StreetBiz {
	/**
	 * 根据区id查询所有的街道
	 * @return
	 */
	public List<Street> getStreetByDistrictId(Integer id);
}
