package com.theara.spring.controller;

import com.theara.spring.model.MData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Theara Seng
 * created on Apr 09, 2020
 */

@Controller
@RequestMapping("/api/")
public class ResourceController {

	@RequestMapping(value = "/resource/{name}", method = RequestMethod.GET)
	@ResponseBody
	public MData resource(@PathVariable("name") String name, @RequestHeader(value = "Authorization", required = false) String authToken) {

		MData res = new MData();
		res.setString("message", "This is the secret resource");
		res.setString("name", name);
		res.setString("authToken", authToken);
		System.out.println(authToken);
		return res;

	}

}
