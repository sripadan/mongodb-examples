package com.naren.spring.mongodb.main2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

	@Override
	public String getDatabaseName() {
		return "yourdb";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient("127.0.0.1", 27017);
		
		/* <mongo:options connections-per-host="4"
	                connect-timeout="1000"
	                max-wait-time="1500"
	                auto-connect-retry="true"
	                socket-keep-alive="true"
	                socket-timeout="1500" write-fsync="true" />
        */
	}
}