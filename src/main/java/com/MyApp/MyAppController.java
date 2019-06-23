package com.MyApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example/v1/users")
public class MyAppController {

	@RequestMapping("/welcome")
	public String WelcomeMessage() {
		return "Welcome to Spring Boot App";
	}
	// REST API development
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Object> Users() {
		Map<Object, Object> user = new HashMap<>();
		user.put("name", "Vinay");
		List<Object> users = new ArrayList<>(); // This list is object type
		users.add(user);
		return users;
	}
}
