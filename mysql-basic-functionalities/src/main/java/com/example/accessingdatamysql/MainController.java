package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.*;
import java.io.*;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/access")
public class MainController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/newUser")
	public @ResponseBody
	String addNewUser(@RequestParam String name, @RequestParam String email, @RequestParam String phone, @RequestParam String DOB, @RequestParam Character gender) {
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		n.setPhone(phone);
		n.setDOB(DOB);
		n.setGender(gender);
		userRepository.save(n);
		return "New User Created";
	}

	@GetMapping(path = "/getAll")
	public @ResponseBody
	Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}

	@GetMapping(path = "/randomQuote")
	public @ResponseBody String getRandom() throws IOException {
		// This returns a JSON or XML with the users
		String url = "https://api.kanye.rest/?format=text";
		URL kanye = new URL(url);
		URLConnection yc = kanye.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String input;
		input = in.readLine();
		in.close();
		return input;
	}

	@PutMapping(path = "/update/{id}")
	public @ResponseBody
	String updateUser(@PathVariable(name = "id") Integer id,
						@RequestParam(required = false) String name, @RequestParam(required = false) String email,
						@RequestParam(required = false) String phone, @RequestParam(required = false) String DOB,
						@RequestParam(required = false) Character gender) {
		User user;
		user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		String updates = "";
		if(name!=null){
			user.setName(name);
			updates += "name ";
		}
		if(email!=null){
			user.setEmail(email);
			updates += "email ";
		}
		if(phone!=null){
			user.setPhone(phone);
			updates += "phone ";
		}
		if(DOB!=null){
			user.setDOB(DOB);
			updates += "DOB ";
		}
		if(gender!=null){
			user.setGender(gender);
			updates += "gender ";
		}
		userRepository.save(user);

		return "Updated "+updates;
	}

}
