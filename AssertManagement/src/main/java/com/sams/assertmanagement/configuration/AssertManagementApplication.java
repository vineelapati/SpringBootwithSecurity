package com.sams.assertmanagement.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@SpringBootApplication
@ComponentScan("com.sams.assertmanagement")
public class AssertManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssertManagementApplication.class, args);
	}
	
	@Bean
	public MongoTemplate mongoTemplate(MongoDbFactory dbFactory,MongoMappingContext context)
	{
		MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(dbFactory), context);
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		MongoTemplate mongoTemplate = new MongoTemplate(dbFactory,converter);
		
		return mongoTemplate;
	}
 
}
