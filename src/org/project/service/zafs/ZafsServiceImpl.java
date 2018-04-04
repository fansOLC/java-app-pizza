package org.project.service.zafs;

import java.util.List;

import javax.annotation.Resource;

import org.project.dao.Zafs.ZafsMapper;
import org.project.pojo.Zafs;
import org.springframework.stereotype.Service;

@Service(value="ZafsService")
public class ZafsServiceImpl implements ZafsService {
	
	@Resource
	ZafsMapper zafsMapper;
	
	@Override
	public List<Zafs> getZafs() {
		// TODO Auto-generated method stub
		return zafsMapper.getZafs();
	}

}
