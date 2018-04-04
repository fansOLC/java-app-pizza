package org.project.controller.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class UploadController {
	@RequestMapping(value="/getFileUploadPage")
	public String fileUpload(){
		return "wjgl/fileManager";
	}
	
	@RequestMapping(value="/uploadFile",method=RequestMethod.POST)
	@ResponseBody
	public String uploadFile(@RequestParam("pic")CommonsMultipartFile pic,HttpServletRequest req,HttpServletResponse response) throws IOException{

		//设置文件保存的本地路径

		String filePath = req.getSession().getServletContext().getRealPath("/uploadFiles/");
		System.out.println(filePath);

		String fileName = pic.getOriginalFilename();

		String fileType = fileName.split("[.]")[1];

		//为了避免文件名重复，在文件名前加UUID

		String uuid = UUID.randomUUID().toString().replace("-","");

		String uuidFileName = uuid + fileName;

		File f = new File(filePath+"/"+uuid+"."+fileType);
		System.out.println(f);

		//将文件保存到服务器

		FileUtil.upFile(pic.getInputStream(), uuidFileName, filePath);

		return uuidFileName;

		}
}
