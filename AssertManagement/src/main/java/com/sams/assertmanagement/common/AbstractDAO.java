package com.sams.assertmanagement.common;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * @author SPSOFT
 *
 */
public abstract class AbstractDAO<T extends Serializable , ID>
{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	private Class<T> persistenceClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		Type type = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        this.persistenceClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	public T findOne(Query query)
	{
		return mongoTemplate.findOne(query, persistenceClass);
	}
	
	public T save(T document)
	{
		return mongoTemplate.save(document);
	}
	
	public List<T> findAll()
	{
		return mongoTemplate.findAll(persistenceClass);
	}
	
	public T findById(ID id)
	{
		return mongoTemplate.findById(id, persistenceClass);
	}
	
	public void delete(T document)
	{
		mongoTemplate.remove(document);
	}
	
	public T update(Query query,Update updatedClass)
	{
		return mongoTemplate.findAndModify(query, updatedClass,new FindAndModifyOptions().returnNew(true), persistenceClass);
	}

}
