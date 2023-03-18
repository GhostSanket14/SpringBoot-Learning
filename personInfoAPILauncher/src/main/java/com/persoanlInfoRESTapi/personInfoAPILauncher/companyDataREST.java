package com.persoanlInfoRESTapi.personInfoAPILauncher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class companyDataREST {

	@Autowired
	public companyData comData;
	
	@RequestMapping("/companyChaData")
	public companyData companyDataDe() {
		return comData;
	}
}