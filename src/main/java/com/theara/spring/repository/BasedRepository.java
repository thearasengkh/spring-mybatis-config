package com.theara.spring.repository;

import com.theara.spring.dao.MDataDao;
import com.theara.spring.dao.impl.MDataDaoImpl;
import com.theara.spring.model.MData;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Theara Seng
 * created on Jan 14, 2020
 */

public class BasedRepository {

	@Autowired
	private MDataDao dao;

	public MData selectOne(final String namespace, final String statementID, MData input) {
		return this.dao.selectOne(namespace, statementID, input);
	}

}
