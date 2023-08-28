package com.SanketFirstRestApp.RestfulWebServices01.FilteringDynamic;

import java.util.Arrays;
import java.util.List;

import org.hibernate.annotations.DialectOverride.Filters;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class filteringControllerDynamic {
	
	@GetMapping("/filteringDynamic")
	public MappingJacksonValue filtering() {
		someBeanDyna someBeanObj = new someBeanDyna("Value1","Value2","Value3");
		
		MappingJacksonValue mapJaksonObj=new MappingJacksonValue(someBeanObj); // Basically we will use 'MappingJacksonValue' to perform filtering on someBean 
		// Now this class allow us ability to set filters.
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3"); // We made a filter. You can try diff methods later.
																							// for now i will use '.filterOutAllExcept()'
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter); // Addes it to a filter provider.
		mapJaksonObj.setFilters(filters); // finally that filter provider will map it to Jackon.
				// Ans we will use this to map over any bean, with anno @JsonFilter
		return mapJaksonObj;
	}
	
	@GetMapping("/filtering-listDynamic")
	public MappingJacksonValue filteringList() {
		List<someBeanDyna> asList = Arrays.asList(new someBeanDyna("Value1","Value2","Value3"),
				new someBeanDyna("Value1","Value2","Value3"),
				new someBeanDyna("Value1","Value2","Value3"));
		
		MappingJacksonValue mapJaksonObj=new MappingJacksonValue(asList); // Basically we will use 'MappingJacksonValue' to perform filtering on someBean 
		// Now this class allow us ability to set filters.
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3"); // We made a filter. You can try diff methods later.
																							// for now i will use '.filterOutAllExcept()'
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter); // Addes it to a filter provider.
		mapJaksonObj.setFilters(filters); // finally that filter provider will map it to Jackon.
				// Ans we will use this to map over any bean, with anno @JsonFilter
		return mapJaksonObj;
		
		
	} // YOU can see duplication in this code, see if you can remove it.
}