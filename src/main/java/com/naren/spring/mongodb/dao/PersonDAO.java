package com.naren.spring.mongodb.dao;

import com.naren.spring.mongodb.domain.Person;

public interface PersonDAO {

	public void create(Person p);
	
	public Person readById(String id);
	
	public void update(Person p);
	
	public int deleteById(String id);
}
