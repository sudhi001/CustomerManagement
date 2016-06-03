package com.akash.spring.crm.generator;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdGenerator implements IdentifierGenerator{

	public String generateId() {
		Random rand = new Random();
		Integer n = rand.nextInt(100);
		return n.toString();
	}

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		Calendar calendar = Calendar.getInstance();
		return "c_" + this.generateId() + "_" + calendar.get(Calendar.MONTH);
	}
}
