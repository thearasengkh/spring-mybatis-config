package com.theara.spring.service.impl;

import com.theara.spring.model.MData;
import com.theara.spring.model.common.UserDto;
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

	@Override
	public MData retrieveUserInfo(MData param) {
		return this.userRepository.retrieveUserInfo(param);
	}

	@Override
	public UserDto retrieveUserDtoInfo(MData param) {
		MData user = this.retrieveUserInfo(param);
		return this.getUserDto(user);
	}

	private UserDto getUserDto(MData userInfo) {
		UserDto userDto = new UserDto();
		userDto.setFirstName(userInfo.getString("firstName"));
		userDto.setLastName(userInfo.getString("lastName"));
		userDto.setEmail(userInfo.getString("email"));
		return userDto;
	}

}
