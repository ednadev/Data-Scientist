package com.encore.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.encore.rest.domain.Greeting;

@RestController
public class GreetingController {
	//필드추가
	private static final String TEMPLATE = "Hi~~~, %s";
	private final AtomicLong counter = new AtomicLong();

	//http://127.0.0.1:8888/rest/greet --> selectList
	@GetMapping("/greet") //GetMapping("/greet")
	public Greeting sayGreet() {
		return new Greeting(314L, "Restful API");
	}
	
	//http://127.0.0.1:8888/rest/greet/33 --> selectOne
	/*
	 * @PathVariable은 파라미터를 URL 경로에 포함시키는 방법이다.
	 * {}를 이용해서 매핑되는 URL 경로에 작성해주면 해당 @PathVariable 어노테이션으로 작성된 파라미터에 
	 * 자동으로 매핑된다.
	 * 
	 */
	@GetMapping("greet/{id}")
	public String showSample(@PathVariable int id) {
		return "Hello RestfulAPI case number..." + id;
	}
	
	//http://127.0.0.1:8888/rest/greet2?name=승현
	//http://127.0.0.1:8888/rest/greet2?name=
	@GetMapping("/greet2")
	public Greeting sayGreet2(@RequestParam(value="name", required=false, defaultValue="world") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
	}
}
