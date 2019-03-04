package com.yucaijr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yucaijr.dao.SysLogDao;
import com.yucaijr.model.SysLog;
import com.yucaijr.service.SysLogService;

@Service(value="sysLogService")
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public void insert(SysLog sysLog) {
		sysLogDao.insert(sysLog);
		
	}

}
