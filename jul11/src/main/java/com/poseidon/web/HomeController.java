package com.poseidon.web;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//나는 /(슬러시)요청이 왔을 때 동작할거야.
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/home")
	//나는 /home 요청이 왔을 때 동작할거야
	public String home() {
		return "home2";
	}
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView("main");//jsp
		
		
		//리스트 list = 10,20,30 ... 100까지
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 11; i++) {
			int a = i*10;
			list.add(a);
		}
		mv.addObject("list", list);
		
		
		mv.addObject("name", "홍길동");//객체 보내기
		return mv;//mv 안에다가
	}
	//이자리는 너무 좋다 신의자리!!!
	
}
