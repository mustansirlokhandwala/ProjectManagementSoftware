package com.project.me.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.project.me.AdException;
import com.project.me.pojo.Message;

@Repository
public class MessageDAO extends DAO {
	
	
	public  List<Message> getUserAccount(String toUser) throws AdException{
		
	    try {
	            begin();
	            Query q = getSession().createQuery("from Message");	               
	            List<Message> message = q.list();	           
	            commit();
	            return message;
	        } catch (HibernateException e) {
	            rollback();
	        	throw new AdException("the error cause due tp "+e.getMessage());
			}
			finally{
			  close();
			}
	    
}
	
public  void addMessaget(Message message){
		
	    try {
	            begin();
	            getSession().save(message);   
	  	        commit();
	           
	        } catch (HibernateException e) {
	            rollback();
	            
	        } finally{
	        	close();
	        
	        }
	    
}

}
