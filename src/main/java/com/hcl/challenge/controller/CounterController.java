package com.hcl.challenge.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/counter")
@RestController
public class CounterController {
	private static HashMap<String,Integer> map = new HashMap<>();
	
	@RequestMapping(value="count")
	public void countKey(@RequestParam("key") String key) {
		Integer val = map.get(key);
		
		if(val == null) {
			map.put(key, 1);
		}else {
			map.put(key, val+1);
		}
	}

	@RequestMapping("getCount")
	public String getCountKey(@RequestParam("key") String key) {
		return "Count of "+key + " is "+String.valueOf(map.get(key));
	}
}
