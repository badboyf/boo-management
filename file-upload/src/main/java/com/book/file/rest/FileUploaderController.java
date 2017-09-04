package com.book.file.rest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.book.common.constant.ExceptionConstant;
import com.book.common.excption.RunException;
import com.book.file.api.FileUploaderApi;

@RestController("fileUploaderController")
public class FileUploaderController implements FileUploaderApi {
	private static final String BASE_DIR = "f://file-repository//";
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss_SSSS");
	private String[] strs = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };

	@Override
	public String uploadFile(@RequestBody MultipartFile file) {
		System.out.println(file.getName());
		System.out.println(file.getSize());
		System.out.println(file.getOriginalFilename());

		String fileName = file.getOriginalFilename();
		File dest = generateDestFile(fileName);
		toDestFile(file, dest);

		return dest.getAbsolutePath();
	}

	private File generateDestFile(String fileName) {
		String lastStr = fileName.substring(fileName.lastIndexOf("."));
		String fileDir = BASE_DIR + generateFileName() + lastStr;
		File dest = new File(fileDir);
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}

		return dest;
	}

	private String generateFileName() {
		String dateStr = format.format(new Date());
		for (int i = 0; i < 10; i++) {
			dateStr += strs[new Random().nextInt(10)];
		}

		return dateStr;
	}

	private void toDestFile(MultipartFile originFile, File destFile) {
		try {
			originFile.transferTo(destFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw new RunException(ExceptionConstant.UPLOAD_FILE_ERROR);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RunException(ExceptionConstant.UPLOAD_FILE_ERROR);
		}
	}

}
