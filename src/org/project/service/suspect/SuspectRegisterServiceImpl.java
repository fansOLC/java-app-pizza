package org.project.service.suspect;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.project.dao.suspect.SuspectRegisterMapper;
import org.project.pojo.SuspectRegister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Service(value="SuspectRegisterService")
public class SuspectRegisterServiceImpl implements SuspectRegisterService {
	
	@Resource
	private SuspectRegisterMapper suspectRegisterMapper;
	
	@Override
	public int suspectDataregister(@RequestParam MultipartFile file,HttpServletRequest req) {
		SuspectRegister suspectRegister=new SuspectRegister();
		
		
		//指定上传位置
		String uploadFilePath=req.getSession().getServletContext().getRealPath("/static/upload");
		
		  /*System.out.println(file.getOriginalFilename());//文件原始名
		  System.out.println(file.getContentType());//文件类型
		  System.out.println(file.getName());//表单控件名
*/         	
		try {
			if(!file.isEmpty()){
				long randomTime=System.currentTimeMillis();
				suspectRegister.setFile_name(file.getOriginalFilename());
				suspectRegister.setFile_addr(uploadFilePath+File.separator+randomTime+file.getOriginalFilename());
				//File.separator--->windows\linux路径分隔符    替代"/"，-->自动识别
				//上传位置
				File saveFile=new File(uploadFilePath+File.separator+randomTime+file.getOriginalFilename());
					//copyInputStreamToFile-->没有"upload"文件夹就会自己创建
					FileUtils.copyInputStreamToFile(file.getInputStream(), saveFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		suspectRegister.setJg(req.getParameter("jg"));
		suspectRegister.setName(req.getParameter("xm"));
		suspectRegister.setAge(req.getParameter("nl"));
		//suspectRegister.setRysj(req.getParameter("rysj"));
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf.parse(req.getParameter("rysj"));
			suspectRegister.setRysj(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		suspectRegister.setRyyy(req.getParameter("ryyy"));
		suspectRegister.setSfzId(req.getParameter("sfzh"));
		suspectRegister.setXb(req.getParameter("xb"));
		suspectRegister.setXq(req.getParameter("xq"));
		// TODO Auto-generated method stub
		return suspectRegisterMapper.suspectDataregister(suspectRegister);
	}

}
