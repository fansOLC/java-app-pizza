package org.project.service.suspect;

import javax.servlet.http.HttpServletRequest;

import org.project.pojo.SuspectRegister;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface SuspectRegisterService {
	//登记嫌疑人信息
	public int suspectDataregister(@RequestParam MultipartFile file,HttpServletRequest req);
}
