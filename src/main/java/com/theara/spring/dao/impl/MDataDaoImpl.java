package com.theara.spring.dao.impl;

import com.theara.spring.dao.MDataDao;
import com.theara.spring.model.MData;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * @author Theara Seng
 * created on Jan 10, 2020
 */

public class MDataDaoImpl extends SqlSessionDaoSupport implements MDataDao {

    public <T> T selectOne(final String namespace, final String statementID, MData input) {

        return this.getSqlSession().<T>selectOne(namespace.concat(".").concat(statementID));

    }

}
