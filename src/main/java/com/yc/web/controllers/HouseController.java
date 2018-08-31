package com.yc.web.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.House;
import com.yc.bean.JsonModel;
import com.yc.bean.PageBean;
import com.yc.bean.User;
import com.yc.biz.HouseBiz;
import com.yc.biz.UserBiz;
import com.yc.fileupload.FileUploadService;

@Controller
@Scope(value="prototype")
public class HouseController {
	@Resource(name="houseBizImpl")
	private HouseBiz houseBiz;
	
	@Resource(name="fileUploadServiceImpl")
	private FileUploadService fus;

	@RequestMapping("getHouseList.action")
	@ResponseBody
	public PageBean listHouse(Integer pages) {
		int pagesize = 3;
		PageBean<House> pb = new PageBean<House>();
		Map<String,Object> map = new HashMap<String,Object>();
		Integer start = 0,end = 0;
		if(pages!=null) {
			start = (pages-1)*pagesize;
			map.put("pages", pages);
			map.put("start", start);
			map.put("pagesize", pagesize);
		}
		try {
			pb = houseBiz.searchHouseByPage(map);
			//System.out.println(pb);
			pb.setCode(1);
		} catch (Exception e) {
			pb.setCode(0);
			e.printStackTrace();
		}
		return pb;
	}
	
	@RequestMapping("getHouseById.action")
	@ResponseBody
	public JsonModel getHouseById(House house) {
		JsonModel jsonModel = new JsonModel();
		//House house = new House();
		//house.setId(1);
		House h = houseBiz.getHouseBean(house);
		//System.out.println(h);
		jsonModel.setCode(1);
		jsonModel.setObj(h);
		return jsonModel;
	}
	
	@RequestMapping("addHouse.action")
	@ResponseBody
	public JsonModel addHouse(House house,HttpSession session,HttpServletRequest request) {
		JsonModel  jsonModel = new JsonModel();
		try {
			User u = (User) session.getAttribute("user");
			house.setUser(u);
			 String path = fus.fileUpload(request);
			 house.setHouseimg(path);
			//System.out.println(house);
			houseBiz.addHosue(house);
			
			jsonModel.setCode(1);
			jsonModel.setObj(path);
		} catch (Exception e) {
			jsonModel.setCode(0);
			jsonModel.setErrmsg(e.toString());
			e.printStackTrace();
		}
		return jsonModel;
	}
	
	@RequestMapping("updateHouse.action")
	@ResponseBody
	public JsonModel updateHouse(House house,HttpSession session,HttpServletRequest request) {
		JsonModel  jsonModel = new JsonModel();
		try {
			User u = (User) session.getAttribute("user");
			house.setUser(u);
			 String path = fus.fileUpload(request);
			 house.setHouseimg(path);
			System.out.println(house);
			houseBiz.updateHouse(house);
			
			jsonModel.setCode(1);
			jsonModel.setObj(path);
		} catch (Exception e) {
			jsonModel.setCode(0);
			jsonModel.setErrmsg(e.toString());
			e.printStackTrace();
		}
		return jsonModel;
	}
	
	@RequestMapping("delHouse.action")
	@ResponseBody
	public JsonModel delHouse(Integer id) {
		JsonModel jsonModel = new JsonModel();
		try {
			houseBiz.delHouse(id);
			jsonModel.setCode(1);
		} catch (Exception e) {
			jsonModel.setCode(0);
			jsonModel.setErrmsg(e.toString());
			e.printStackTrace();
		}
		return jsonModel;
	}
}
