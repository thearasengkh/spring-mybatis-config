package com.theara.spring.repository;

import com.theara.spring.model.MData;
import com.theara.spring.model.common.UserDto;
import org.springframework.stereotype.Repository;

/**
 * @author Theara Seng
 * created on Jan 14, 2020
 */

@Repository
public class UserRepository extends BasedRepository {

	private static String NAMESPACE = UserRepository.class.getName();

	public MData retrieveUserInfo(MData param) {
		return this.selectOne(NAMESPACE, "retrieveUserInfo", param);
	}

	public int registerUserInfo(MData param) {
		return this.insert(NAMESPACE, "registerUserInfo", param);
	}

}
