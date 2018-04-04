package org.project.service.suspect;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.project.dao.suspect.SuspectSearchMapper;
import org.project.pojo.Pagenation;
import org.project.pojo.SuspectRegister;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
@Service(value="suspectSearchService")
public class SuspectSearchServiceImpl implements SuspectSearchService {
	
	@Resource
	private SuspectSearchMapper suspectSearchMapper;
	
	@Override
	public Map<String,Object> searchList(HttpServletRequest request) {
		Pagenation pagenation=new Pagenation();
		Map<String, Object> resultMap=new HashMap<String, Object>();
		List<SuspectRegister> suspectList=new ArrayList<SuspectRegister>();
		SuspectRegister suspectRegister=new SuspectRegister();
		suspectRegister.setName(request.getParameter("name"));
		suspectRegister.setAge(request.getParameter("age"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
	    Date date = null;
		try {
			date = sdf.parse(request.getParameter("rysj"));
		} catch (ParseException e) {
		}  
		suspectRegister.setRysj(date);
		suspectRegister.setJg(request.getParameter("jg"));
		
		int pageNo=Integer.parseInt(request.getParameter("pageNo"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		int totalCount=this.count(suspectRegister);
		pagenation.setPageNo(pageNo);
		pagenation.setPageSize(pageSize);
		int pageCount = 0;
		if (totalCount % pageSize == 0) {
			pageCount = totalCount / pageSize;
		} else {
			pageCount = totalCount / pageSize + 1;
		}
		pagenation.setCount(totalCount);
		pagenation.setPageCount(pageCount);
		PageHelper.startPage(pageNo, pageSize);//分页工具
		suspectList=suspectSearchMapper.searchList(suspectRegister);
		resultMap.put("page", pagenation);
		resultMap.put("content", suspectList);
		return resultMap;
	}

	@Override
	public int count(SuspectRegister suspectRegister) {
		return suspectSearchMapper.count(suspectRegister);
	}

	@Override
	public Map<String, Object> searchFile(int susId) {
		Map resultMap=new HashMap<String, Object>();
		resultMap=suspectSearchMapper.searchFile(susId);
		return resultMap;
	}

}
