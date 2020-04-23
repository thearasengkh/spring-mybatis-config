package com.theara.spring.controller;

import com.theara.spring.model.MData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Theara Seng
 * created on Apr 09, 2020
 */

@Controller
@RequestMapping("/api/")
public class AuthenticationController {

	private static long sequence = 11110000;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	@ResponseBody
	public MData authenticate(@RequestBody MData requestBody) {

		MData response = new MData();
		MData user = new MData();

		user.setString("username", requestBody.getString("username"));
		user.setString("password", requestBody.getString("password"));

		response.setString("id_token", sequence++ + "");
		response.put("user", user);

		return response;
	}

}
