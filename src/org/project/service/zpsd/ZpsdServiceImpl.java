package org.project.service.zpsd;

import java.util.List;

import javax.annotation.Resource;

import org.project.dao.Zpsd.ZpsdMapper;
import org.project.pojo.Zpsd;
import org.springframework.stereotype.Service;
@Service(value="ZpsdService")
public class ZpsdServiceImpl implements ZpsdService {
	
	@Resource
	ZpsdMapper zpsdMapper;
	
	@Override
	public List<Zpsd> getZpsdfl() {
		return zpsdMapper.getZpsdfl();
	}

	@Override
	public List<Zpsd> getZpsddl(Zpsd zpsd) {
		return zpsdMapper.getZpsddl(zpsd);
	}

	@Override
	public List<Zpsd> getZpsdxl(Zpsd zpsd) {
		return zpsdMapper.getZpsdxl(zpsd);
	}

}
