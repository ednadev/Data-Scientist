package com.encore.pms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;
import com.encore.pms.service.IPhoneService;

@Controller
public class MainController {	
		
	@Autowired
	private IPhoneService iphoneService;
	
	@RequestMapping("regPhone.do")
	public String regPhone() {
		return "PhoneReg";
	}
	
	@RequestMapping("searchPhone.do")
	public String searchPhone(Model model) {
		List<Phone> list = iphoneService.select();
		model.addAttribute("list", list);
		return "PhoneList";
	}

	@RequestMapping("savePhone.do")
	public String savePhone(String num, String model, int price, String vcode) {
		int result = iphoneService.insert(new Phone(num, model, price, vcode));
		if(result!=1) {
			return "Error";
		}
		return "Result";
	}
	
	@RequestMapping("showPhone.do")
	public String showPhone(Model model, String num) {
		Phone phone = new Phone();
		phone.setNum(num);
		Phone vo = iphoneService.select(phone);
		model.addAttribute("vo", vo);
		return "PhoneView";
	}
	
	@RequestMapping("delete.do")
	public String delPhone(@RequestParam(value="phone", required=true) List phone) {
		iphoneService.delete(phone);
		return "JsonView"; 
	}
	
	@RequestMapping("loginPage.do")
	public String loginPage() {
		return "Login";
	}
	
	@RequestMapping("login.do")
	public ModelAndView login(HttpServletRequest request, String id, String pw) {
		UserInfo user = iphoneService.select(new UserInfo(id, pw));
		HttpSession session = request.getSession();
		if(user!=null) {
			session.setAttribute("loginUser", user);
			return new ModelAndView("index");
		}
		return new ModelAndView("Login");
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")!=null) {
			session.invalidate();
			return "index";
		}
		return null;
	}
}