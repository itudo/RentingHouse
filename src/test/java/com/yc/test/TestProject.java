package com.yc.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.bean.District;
import com.yc.bean.House;
import com.yc.bean.HouseType;
import com.yc.bean.JsonModel;
import com.yc.bean.PageBean;
import com.yc.bean.Street;
import com.yc.bean.User;
import com.yc.biz.DistrictBiz;
import com.yc.biz.HouseBiz;
import com.yc.biz.HouseTypeBiz;
import com.yc.biz.StreetBiz;
import com.yc.biz.UserBiz;
import com.yc.biz.impl.UserBizImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:beans.xml","classpath*:beans-dao.xml"})
public class TestProject {
	@Resource(name="userBizImpl")
	private UserBiz userBiz;
	
	@Resource(name="houseBizImpl")
	private HouseBiz houseBiz;
	
	@Resource(name="houseTypeBizImpl")
	private HouseTypeBiz houseTypeBiz;
	
	@Resource(name="districtBizImpl")
	private DistrictBiz districtBiz;
	
	@Resource(name="streetBizImpl")
	private StreetBiz streetBiz;
	
	@Test
	public void getUserById() {
		User user = userBiz.getUserById(2);
		System.out.println(user);
	}
	@Test
	public void userRegister() {
		User user = userBiz.getUserById(2);
		user.setUsername("d");
		user.setPassword("d");
		int u = userBiz.register(user);
		System.out.println(u);
	}
	@Test
	public void searchHouseById() {
		House house = new House();
		house.setId(1);
		House h = houseBiz.getHouseBean(house);
		System.out.println(h);
	}
	@Test
	public void searchHouse() {
		Map<String,Object> map = new HashMap<String,Object>();
		int pages = 2;
		int pagesize = 5;
		int start = (pages-1)*pagesize;
		map.put("pages", pages);
		map.put("start", start);
		map.put("pagesize", pagesize);
		PageBean<House> pb = houseBiz.searchHouseByPage(map);
		System.out.println(pb.getList().size());
		System.out.println(pb);
	}
	@Test
	public void getTypeList() {
		List<HouseType> list = houseTypeBiz.getTypeList();
		System.out.println(list);
	}
	@Test
	public void getDistrict() {
		List<District> list = districtBiz.getDistrictList();
		System.out.println(list);
	}
	@Test
	public void getStreet() {
		List<Street> list = streetBiz.getStreetByDistrictId(1004);
		System.out.println(list);
	}
	@Test
	public void test1() {
		String name="1231231.jsp";
		System.out.println(name.substring(name.length()-3,name.length()));
	}
	@Test
	public void test2() {
		Integer a = 2;
		Integer b = 10;
		System.out.println(a/b);
	}
}
