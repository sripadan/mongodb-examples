package com.naren.spring.mongodb.main1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naren.spring.mongodb.dao.PersonDAO;
import com.naren.spring.mongodb.domain.Person;

public class SpringMongoDBAnnotationMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoDBConfiguration.class);
		
		PersonDAO personDAO = ctx.getBean("personDAOImpl", PersonDAO.class);
		
		Person p = new Person(null, "PankajKr", "Bangalore, India");
		
		//create
		personDAO.create(p);
		System.out.println("Generated ID="+p.getId());
		
		//read
		Person p1 = personDAO.readById(p.getId());
		System.out.println("Retrieved Person="+p1);
		
		//update
		p1.setName("David");p1.setAddress("SFO, USA");
		personDAO.update(p1);
		Person temp = personDAO.readById(p1.getId());
		System.out.println("Retrieved Person after update="+temp);
		
		//delete
		int count = personDAO.deleteById(p1.getId());
		System.out.println("Number of records deleted="+count);
		
	}

}
