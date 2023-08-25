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

// Versioning using params
	@GetMapping(path="/person", params="version1") // this means, this method will be called, only if there is request for param 'version1' 
	public PersonV1 personDataViaRequestParamsV1() {
		return new PersonV1("Sanket Ghost");
	}
	
	@GetMapping(path="/person", params="version2") // this means, this method will be called, only if there is request for param 'version2' 
	public PersonV2 personDataViaRequestParamsV2() {
		return new PersonV2(new Name("Sanket","Ghost"));
	}

// Versioning using header, SAME URL
	@GetMapping(path="/person/header", headers="X-API-VERSION=1") 
	public PersonV1 personDataViaRequestHeaderV1() {
	return new PersonV1("Sanket Ghost");
	}
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=2")
	public PersonV2 personDataViaRequestHeaderV2() {
		return new PersonV2(new Name("Sanket","Ghost"));
	}
	
	// Versioning using produces/ media type.    SAME URL
		@GetMapping(path="/person/produces/accept", produces="application/vnd.company.app-v1+json") 
		public PersonV1 personDataViaRequestproducesV1() {
		return new PersonV1("Sanket Ghost");
		}
		
					// Sanket dont forget to add accept in url as it is a content negotiation type url.
		@GetMapping(path="/person/produces/accept", produces="application/vnd.company.app-v2+json")
		public PersonV2 personDataViaRequestproducesV2() {
			return new PersonV2(new Name("Sanket","Ghost"));
	}
}