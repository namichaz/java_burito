package com.example.java_burito;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/api/hello")
	public Map<String ,String>hello(@RequestParam(defaultValue = "Anonymous")String name){
		var response = new HashMap<String, String>();
		response.put("message","こんにちは"+ name + "さん");
		return response;
	}
}
