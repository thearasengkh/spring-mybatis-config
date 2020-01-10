package com.theara.spring.dao;

import com.theara.spring.model.MData;

/**
 * @author Theara Seng
 * created on Jan 10, 2020
 */

public interface MDataDao {

    MData selectOne(final String namespace, final String statementID, MData input);

}
