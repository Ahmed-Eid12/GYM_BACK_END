package com.ahmedeid.securityandjwt.demo.manager;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class IntegrationManager {
	
	@Value("${user.image.path}")
	private final String USER_IMAGE = "/home/ahmed/java-projects/GYM/gym/src/assets/playerImage"; 
	
	public String updateImage(MultipartFile file) {
		
		try {
			
			String fileName = file.getOriginalFilename();
			String extention = fileName.substring(fileName.lastIndexOf("."));
			
			Date date = new Date();
			fileName = date.getTime() + extention ;
			
			String filePath = USER_IMAGE + "\\" + fileName;
			
			if(filePath != null && !filePath.equals("")) {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
						new File(USER_IMAGE + File.separator + fileName)));
				stream.write(bytes);
				stream.flush();
				stream.close();
				
				return fileName;
			}
			
		} catch(Exception ex) {
			
		}
		return null;
		
	}

}
