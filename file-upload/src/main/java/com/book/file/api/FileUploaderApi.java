package com.book.file.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(value = "/file")
public interface FileUploaderApi {

	@RequestMapping(method= RequestMethod.POST)
	public String uploadFile(@RequestBody MultipartFile file);
}
