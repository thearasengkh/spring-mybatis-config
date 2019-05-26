package com.theara.spring.dao.impl;

import com.theara.spring.dao.UserDao;
import com.theara.spring.model.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author Theara Seng
 * created on May 26, 2019
 */

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    private static final String namespace = User.class.getName();

    public List<User> selectAll() {
        return this.getSqlSession().selectList(namespace.concat(".selectAll"));
    }

}
