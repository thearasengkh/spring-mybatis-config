package com.theara.spring.dao.impl;

import com.theara.spring.dao.MDataDao;
import com.theara.spring.dao.UserDao;
import com.theara.spring.model.MData;
import com.theara.spring.model.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author Theara Seng
 * created on Jan 10, 2020
 */

public class MDataDaoImpl extends SqlSessionDaoSupport implements MDataDao {

    public MData selectOne(final String namespace, final String statementID, MData input) {

        return this.getSqlSession().selectOne(namespace.concat(statementID));

    }

}
