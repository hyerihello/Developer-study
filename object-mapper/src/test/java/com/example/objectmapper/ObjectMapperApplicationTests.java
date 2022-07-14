package com.example.objectmapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class ObjectMapperApplicationTests {


	@Test
	void contextLoads() throws JsonProcessingException{
		System.out.println("---------test--------");
		
		// Text JSON -> Object
		// Object -> Text JSON
		
		// controller req json (text) - object
		// response object -> json(text)
		
		var objectMapper = new ObjectMapper();
		
		
		// 1. object -> text
		// object mapper가 get method를 활용한다.
		var user = new User("hyeri", 30, "010-1111-2222");
		var text = objectMapper.writeValueAsString(user);
		System.out.println(text);
		
		
		//2. text -> object
		// object mapper는 defalut 생성자를 필요로 한다. 
		// 생성자 오버로딩을 했기 때문에, 디폴트 생성자가 없어도 됬었으나 object를 만들기 위해 디폴트 생성자를 꼭 추가해야한다. 
		var objectUser = objectMapper.readValue(text,User.class);
		System.out.println(objectUser);
	}

}
