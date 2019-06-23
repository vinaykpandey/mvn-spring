package com.MyApp.StaticPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StaticPage {
	
	@RequestMapping("/")
	public String Home() {
		return "home.html";
	}
	
	@RequestMapping("/about")
	public String About() {
		return "about.html";
	}
	@RequestMapping("/product")
	public String Product() {
		return "product.html";
	}
	@RequestMapping("/html")
	@ResponseBody
	public String Html() {
		return ("This is html page");
	}
}