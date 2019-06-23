package com.MyApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAppController {

	@RequestMapping("/welcome")
	public String WelcomeMessage() {
		return "Welcome to Spring Boot App";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String Users() {
		return "List all the users";
	}

	@RequestMapping(value = "/users/add", method = RequestMethod.POST)
	public String AddUser() {
		return "Add new user";
	}
	@RequestMapping("/getuser")
//	public String getUser(@RequestParam String name) {
//		return "Welcome, "+ name;
//	}
	public String getUser(@RequestParam(value="myname") String name) {
		return "Welcome, "+ name + " to my Spring app ";
	}
	
}
