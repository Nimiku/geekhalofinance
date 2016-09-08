package cn.geekhalo.webtech.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value="/")
	public String goHome(HttpServletRequest request){
		return "main";
	}
}
