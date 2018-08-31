package com.yc.fileupload;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	public String fileUpload(HttpServletRequest request);
}
