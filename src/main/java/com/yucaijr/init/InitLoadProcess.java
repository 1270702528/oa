package com.yucaijr.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yucaijr.service.ProcessService;

@Component
public class InitLoadProcess implements CommandLineRunner{

	@Autowired
	 private ProcessService processService;
	
	@Override
	public void run(String... args) throws Exception {
		if(!processService.isDelopy()) {
			processService.delopy();
			processService.addUser("admin");
			processService.addGroup("管理员");
			System.out.println("==================>初次部署");
		}
		
	}

}
