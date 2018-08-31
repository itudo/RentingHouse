<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/ckeditor/ckeditor.js"></script>
<title>租房系统后台</title>
</head>
<%
	FileUpload fu = new FileUpload();
	Map<String,String> map = fu.uploadFiles(pageContext, request);
	session.setAttribute("mapPic", map);
	response.setContentType("text/html; charset=UTF-8");
	String callback = request.getParameter("CKEditorFuncNum");
	out.println("<script type=\"text/javascript\">");
	out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + map.get("weburl_upload") + "','')");
	out.println("</script>");
	out.flush();
%>
