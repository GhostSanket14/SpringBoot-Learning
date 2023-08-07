package com.SanketFirstRestApp.RestfulWebServices01.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class versioningPersonControl {
 // Versioning using URL
	@GetMapping("/person/V1") 
	public PersonV1 personDataV1() {
		return new PersonV1("Sanket Ghost");
	}
	@GetMapping("/person/V2") 
	public PersonV2 personDataV2() {
		return new PersonV2(new Name("Sanket","Ghost"));
	}
}