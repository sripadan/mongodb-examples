package com.naren.spring.mongodb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.mongodb.WriteResult;
import com.naren.spring.mongodb.domain.Person;

@Component
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private MongoOperations mongoOps;
	private static final String PERSON_COLLECTION = "Person";
	
	public void create(Person p) {
		this.mongoOps.insert(p, PERSON_COLLECTION);
	}

	public void setMongoOps(MongoOperations mongoOps){
		this.mongoOps=mongoOps;
	}
	
	public Person readById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoOps.findOne(query, Person.class, PERSON_COLLECTION);
	}

	public void update(Person p) {
		this.mongoOps.save(p, PERSON_COLLECTION);
	}


	public int deleteById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		WriteResult result = this.mongoOps.remove(query, Person.class, PERSON_COLLECTION);
		return result.getN();
	}

}
