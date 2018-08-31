package com.yc.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.District;
import com.yc.bean.House;
import com.yc.bean.HouseType;
import com.yc.bean.JsonModel;
import com.yc.bean.Street;
import com.yc.bean.User;
import com.yc.biz.DistrictBiz;
import com.yc.biz.HouseBiz;
import com.yc.biz.HouseTypeBiz;
import com.yc.biz.StreetBiz;
import com.yc.biz.UserBiz;

@Controller
@Scope(value="prototype")
public class StreetController {
	@Resource(name="streetBizImpl")
	private StreetBiz streetBiz;

	@RequestMapping("getStreet.action")
	@ResponseBody
	public JsonModel getStreet(@Param(value="id") Integer id) {
		JsonModel jsonModel = new JsonModel();
		List<Street> streetList = new ArrayList<Street>();
		try {
			streetList = streetBiz.getStreetByDistrictId(id);
			jsonModel.setCode(1);
			jsonModel.setObj(streetList);
		} catch (Exception e) {
			jsonModel.setCode(0);
			jsonModel.setErrmsg(e.toString());
			e.printStackTrace();
		}
		return jsonModel;
	}
}
