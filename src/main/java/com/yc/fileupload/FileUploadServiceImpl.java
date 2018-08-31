package com.yc.fileupload;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Service
public class FileUploadServiceImpl implements FileUploadService {
	private DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");  //时间格式化
	private String weburl = "";
	private String destFilePathName = "";
	
	public String fileUpload(HttpServletRequest request) {
		//将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
	       CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
	               request.getSession().getServletContext());
	       //检查form中是否有enctype="multipart/form-data"
	       System.out.println(multipartResolver.isMultipart(request));
	       if(multipartResolver.isMultipart(request)) {
	           //将request变成多部分request
	           MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
	          //获取multiRequest 中所有的文件名
	           Iterator iter=multiRequest.getFileNames();

	           while(iter.hasNext()) {
	               //一次遍历所有文件
	               MultipartFile file=multiRequest.getFile(iter.next().toString());
	               if(file!=null) {
	            	   Calendar c = Calendar.getInstance();
		           		String tomcatdir = request.getRealPath("/"); // E:\tomcat\webapps/JavaEE_onlineorder
		           		File tomcatFile = new File(tomcatdir);
		           		File webapppath = tomcatFile.getParentFile(); // E:\tomcat\webapps
		
		           		// E:\tomcat\webapps/pic/2017/7
		           		File picpath = new File(webapppath, "pic" + File.separator + c.get(Calendar.YEAR) + File.separator
		           			+ (c.get(Calendar.MONTH) + 1) + File.separator);
		           		// 访问路径名
		           		String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
		           		weburl = "/pic/" + c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1) + "/";
		           		String path = basePath+weburl;
		           		// 判断目录是否存在，不在则创建
		           		if (picpath.exists() == false) {
		           			picpath.mkdirs();
		           		}
		           		
	            	   String fileName = df.format(new Date()) + file.getOriginalFilename().substring(file.getOriginalFilename().length()-4,file.getOriginalFilename().length());
	            	   weburl += fileName;
	       			// 物理路径: xxx/xxx/webapps/pic/2017/7/20170720222222.png
	       				destFilePathName = picpath + "/" + fileName;
	                   //上传
	                   try {
						file.transferTo(new File(destFilePathName));
						//System.out.println(weburl);
						//System.out.println(destFilePathName);
						System.out.println("上传成功！！！");
					} catch (IllegalStateException | IOException e) {
						System.out.println("上传失败！！！");
						e.printStackTrace();
					}
	               } else {
	            	   System.out.println("文件没找到");
	               }
	           }
	       }
	       return weburl;
	}
}
