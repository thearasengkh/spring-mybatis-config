package com.theara.spring.dao;

import com.theara.spring.model.User;

import java.util.List;

/**
 * @author Theara Seng
 * created on May 26, 2019
 */

public interface UserDao {

    List<User> selectAll();

}
