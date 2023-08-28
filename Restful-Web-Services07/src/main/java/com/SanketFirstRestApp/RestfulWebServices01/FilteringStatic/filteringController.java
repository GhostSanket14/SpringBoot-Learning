package com.SanketFirstRestApp.RestfulWebServices01.FilteringStatic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class filteringController {
	
	@GetMapping("/filteringStatic")
	public someBean filtering() {
		return new someBean("Value1","Value2","Value3");
	}
	
	@GetMapping("/filtering-listStatic")
	public List<someBean> filteringList() {
		return Arrays.asList(new someBean("Value1","Value2","Value3"),
				new someBean("Value1","Value2","Value3"),
				new someBean("Value1","Value2","Value3"));
	}
}