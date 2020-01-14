package com.theara.spring.service.impl;

import com.theara.spring.model.MData;
import com.theara.spring.repository.UserRepository;
import com.theara.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Theara Seng
 * created on Jan 14, 2020
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public MData retrieveUserInfo(MData param) {
		return this.userRepository.retrieveUserInfo(param);
	}

}
