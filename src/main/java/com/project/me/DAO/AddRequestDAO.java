package com.project.me.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.project.me.AdException;
import com.project.me.pojo.AddRequest;

@Repository
public class AddRequestDAO extends DAO {
	
	
	
	public void add (AddRequest addRequest){
		try{
			begin();
			getSession().save(addRequest);
			commit();
		}catch(HibernateException e){
			rollback();
		}
		finally{
			close();
		}
		
	}
	
	
	public AddRequest getRequest(long id) throws AdException{
		try{
			begin();
			Query q = getSession().createQuery("from AddRequest where id = :id ");
            q.setLong("id", id);            
            AddRequest addrequest = (AddRequest) q.uniqueResult();
            return addrequest;       
            
			
		}catch(HibernateException e){
			rollback();
			throw new AdException("the error cause due tp "+e.getMessage());
		}
		finally{
			close();
		}
		
	}
	
	public List<AddRequest> getALLRequest() throws AdException{
		try{
			begin();
			Query q = getSession().createQuery("from AddRequest ");
            List<AddRequest> addrequest= q.list();      
            
            return addrequest;       
            
			
		}catch(HibernateException e){
			rollback();
			throw new AdException("the error cause due tp "+e.getMessage());
		}
		finally{
		  close();
		}
		
	}
		
	}

