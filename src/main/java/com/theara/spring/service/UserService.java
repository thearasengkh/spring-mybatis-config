package com.theara.spring.service;

import com.theara.spring.model.MData;
import com.theara.spring.model.common.UserDto;

/**
 * @author Theara Seng
 * created on Jan 14, 2020
 */

public interface UserService {

	MData retrieveUserInfo(MData param);
	UserDto retrieveUserDtoInfo(MData param);
	int registerUserInfo(MData param);

}
