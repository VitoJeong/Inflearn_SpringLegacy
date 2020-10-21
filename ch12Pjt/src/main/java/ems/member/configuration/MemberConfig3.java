package ems.member.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ems.member.DataBaseConnectionInfo;
import ems.member.service.EMSInformationService;

// @Configuration - xml 설정파일 대신  
//	해당 클래스의 인스턴스를 이용해 container를 생성하는 설정파일 지정
@Configuration
public class MemberConfig3 {
	
	// MemberConfig2에서 등록한 bean객체를 자동주입 요청
	@Autowired
	DataBaseConnectionInfo dataBaseConnectionInfoDev;
	
	@Autowired
	DataBaseConnectionInfo dataBaseConnectionInfoReal;
	
	@Bean
	public EMSInformationService informationService() {
		EMSInformationService infoService = new EMSInformationService();
		infoService.setInfo("Education Management System program was developed in 2015.");
		infoService.setCopyRight("COPYRIGHT(C) 2015 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
		infoService.setVer("The version is 1.0");
		infoService.setsYear(2015);
		infoService.setsMonth(1);
		infoService.setsDay(1);
		infoService.seteYear(2015);
		infoService.seteMonth(2);
		infoService.seteDay(28);
		
		List<String> developers = new ArrayList<String>();
		developers.add("Cheney");
		developers.add("Eloy");
		developers.add("Jasper");
		developers.add("Dillon");
		developers.add("Kian");
		
		infoService.setDevelopers(developers);
		
		Map<String, String> administrators = new HashMap<String, String>();
		administrators.put("Cheney", "cheney@springPjt.org");
		administrators.put("Jasper", "jasper@springPjt.org");
		
		infoService.setAdministrators(administrators);
		
		Map<String, DataBaseConnectionInfo> dbInfos = new HashMap<String, DataBaseConnectionInfo>();
		dbInfos.put("dev", dataBaseConnectionInfoDev);
		dbInfos.put("real", dataBaseConnectionInfoReal);
		
		infoService.setDbInfos(dbInfos);
		
		return infoService;
	}
	
}



