package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserRequest;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
	
	// 아래 RequestMapping을 합친것이 GetMapping 
	@GetMapping(path = "/hello") //http://localhost:9090/api/get/hello
	public String hello() {
		return "get Hello";
	}
	
	
	// @RequestMapping("/hi") : get, post, delete 모두 지정 가능하기 때문에 아래와 같이 지정해서 사
	@RequestMapping(path = "/hi", method = RequestMethod.GET) //http://localhost:9090/api/get/hi
	public String hi() {
		return "hi";
	}
	
	//http://localhost:9090/api/get/path-variable/{변하는값 : spring-boot}
//	@GetMapping("/path-variable/{name}")
//	public String pathVariable(@PathVariable String name) {
//		System.out.println("PathVariable :" + name);
//		return name;
//	}
	
	
	//http://localhost:9090/api/get/path-variable/{변하는값 : spring-boot}
	// (name = "name") 이 부분만 path-variable과 맞춰써줌 
	@GetMapping("/path-variable/{name}")
	public String pathVariable(@PathVariable (name = "name") String pathName) {
		System.out.println("PathVariable :" + pathName);
		return pathName;
	}
	
	// 쿼리연산
	//http://localhost:9090/api/get/query-param?user=hyeri&email=hyerihello@gmail.com&age=30
	// @GetMapping("query-param") - 방법 1
	@GetMapping(path = "query-param") // - 방법 2
	public String queryParam(@RequestParam Map<String, String> queryParam) { //Map = key:value
		
		StringBuilder sb = new StringBuilder();
		
		queryParam.entrySet().forEach(entry ->{ //람다식 
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println("\n");
			
			sb.append(entry.getKey() + "=" + entry.getValue() +'n');
		});
		return sb.toString();
	}
	
	//2. 명시적으로 받기 
	@GetMapping("query-param02")
	public String queryParam02(
			@RequestParam String user,
			@RequestParam String email,
			@RequestParam int age
	) {
		System.out.println(user);
		System.out.println(email);
		System.out.println(age);
		
		return user + " " + email + " " + age;
	}
	
	// 3. 가장 많이 쓰는 방법 DTO 
	@GetMapping("query-param03")
	public String queryParam03(UserRequest userRequest) {
		System.out.println(userRequest.getUser());
		System.out.println(userRequest.getEmail());
		System.out.println(userRequest.getAge());
		
		return userRequest.toString();
	}
}
