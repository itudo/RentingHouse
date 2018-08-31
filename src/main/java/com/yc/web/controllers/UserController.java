package com.yc.web.controllers;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.JsonModel;
import com.yc.bean.User;
import com.yc.biz.UserBiz;

@Controller
@Scope(value="prototype")
public class UserController {
	@Resource(name="userBizImpl")
	private UserBiz userBiz;

	@RequestMapping("userRegister.action")
	@ResponseBody
	public JsonModel register(User user) {
		JsonModel jsonModel = new JsonModel();
		if(!user.getPassword().trim().equals(user.getRepassword().trim())) {
			jsonModel.setCode(0);
			jsonModel.setErrmsg("两次密码输入不一致，请重新输入");
		} else {
			try {
				userBiz.register(user);
				jsonModel.setCode(1);
			} catch (Exception e) {
				e.printStackTrace();
				jsonModel.setCode(0);
			}
		}
		return jsonModel;
	}
	
	@RequestMapping("userLogin.action")
	@ResponseBody
	public JsonModel login(User user,HttpSession session) throws IOException {
		JsonModel jsonModel = new JsonModel();
		User u = userBiz.login(user);
		if(u!=null) {
			jsonModel.setCode(1);
			session.setAttribute("user", u);
		} else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping("getLoginer.action")
	@ResponseBody
	public JsonModel getLoginer(HttpSession session) throws IOException {
		JsonModel jsonModel = new JsonModel();
		User u = (User) session.getAttribute("user");
		if(u!=null) {
			jsonModel.setCode(1);
			jsonModel.setObj(u);
		} else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping("userLogout.action")
	@ResponseBody
	public JsonModel userLogout(HttpSession session) throws IOException {
		JsonModel jsonModel = new JsonModel();
		session.removeAttribute("user");
		jsonModel.setCode(1);
		return jsonModel;
	}
}
