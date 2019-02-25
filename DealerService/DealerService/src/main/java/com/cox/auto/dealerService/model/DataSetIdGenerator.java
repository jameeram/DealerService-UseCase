package com.cox.auto.dealerService.model;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import net.bytebuddy.utility.RandomString;

public class DataSetIdGenerator implements IdentifierGenerator{
	
   	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
   		return RandomString.make();
	}

}