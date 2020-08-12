package com.encore.pms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.encore.pms.dto.Phone;
import com.encore.pms.service.IPhoneService;

@RestController
public class PhoneRestController {

	@Autowired
	private IPhoneService service;
	
	@GetMapping("/phone/{num}")
	public ResponseEntity select(@PathVariable String num) {
		try {
			Phone phone = new Phone();
			phone.setNum(num);
			Phone selected = service.select(phone);
			return new ResponseEntity(selected, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/phone")
	public ResponseEntity select() {
		try {
			List<Phone> selected = service.select();
			System.out.println("selected :: " + selected);
			return new ResponseEntity(selected, HttpStatus.OK);
		} catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/phone")
	public ResponseEntity insert(@RequestBody Phone phone) {
		try {
			int result = service.insert(phone);
			return new ResponseEntity(result, HttpStatus.OK);
		} catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/phone/{num}")
	public ResponseEntity delete(@PathVariable String num) {
		try {
			int result = service.delete(Arrays.asList(num));
			return new ResponseEntity(HttpStatus.OK);
		} catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/phone")
	public ResponseEntity update(@RequestBody Phone phone) throws Exception {
//		int result = service.update();
//		if(result>0) return new ResponseEntity(HttpStatus.OK);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
}
