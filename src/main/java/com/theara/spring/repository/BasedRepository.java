package com.theara.spring.repository;

import com.theara.spring.dao.MDataDao;
import com.theara.spring.model.MData;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Theara Seng
 * created on Jan 14, 2020
 */

public class BasedRepository {

	@Autowired
	private MDataDao dao;

	public <T> T selectOne(final String namespace, final String statementID, MData input) {
		return this.dao.selectOne(namespace, statementID, input);
	}

	public int insert(final String namespace, final String statementID, MData input) {
		return this.dao.insert(namespace, statementID, input);
	}

}
