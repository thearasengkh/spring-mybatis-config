package com.theara.spring.service;

import com.theara.spring.model.User;

/**
 * @author Theara Seng
 * created on Apr 23, 2019
 */

public interface UserService {

    User getUserInfoByEmail(String email);

}
