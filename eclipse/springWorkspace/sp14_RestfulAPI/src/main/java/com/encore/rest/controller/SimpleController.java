package com.encore.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.rest.domain.Person;

@RestController
@RequestMapping("/sample")
public class SimpleController {
	
	//http://127.0.0.1:8888/rest/sample/hello
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Restful Service!!";
	}
	
	//http://127.0.0.1:8888/rest/sample/greet
	@GetMapping("/greet")
	public Person sayGreet() {
		Person vo = new Person("홍길동", "으랴차차");
		return vo;
	}
	
	@GetMapping("/allGreet")
	public List<Person> allGreet() {
		List<Person> list = new ArrayList<Person>();
		for(int i=0; i<3; i++) {
			Person vo = new Person();
			vo.setName("동이, " + i);
			vo.setMessage("으랴차차, " + i);
			list.add(vo);
		}
		return list;
	}
	
	@GetMapping("/sendGreet")
	public Map<Integer, Person> sendGreet() {
		Map<Integer, Person> map = new HashMap<Integer, Person>();
		map.put(1, new Person("홍길동", "으랴차차"));
		return map;
	}
}
