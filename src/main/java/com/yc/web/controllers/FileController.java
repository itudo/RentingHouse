package com.yc.web.controllers;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.yc.bean.JsonModel;
import com.yc.fileupload.FileUploadService;

@Controller
@Scope(value="prototype")
public class FileController {
	@Resource(name="fileUploadServiceImpl")
	private FileUploadService fus;

	@RequestMapping("fileupload.action")
	@ResponseBody
	public JsonModel fileUpload(String userName,HttpServletRequest request) {
		System.out.println(userName);
		JsonModel jsonModel = new JsonModel();
		System.out.println(request);
        String path = fus.fileUpload(request);
        System.out.println(path);
        jsonModel.setCode(1);
        jsonModel.setObj(path);
        return  jsonModel;
	}
}
