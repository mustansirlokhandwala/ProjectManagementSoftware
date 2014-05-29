package com.project.me.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.project.me.AdException;
import com.project.me.pojo.Project;
import com.project.me.pojo.User;

@Repository
public class UserDAO extends DAO {
	
	
	public void addUser(User user) throws AdException{
		try{
			begin();
			getSession().save(user);
			commit();
		}catch(HibernateException e){
			rollback();
			throw new AdException("The error cause due to "+ e.getMessage());
		}
	}
	
	public void deleteUser(User user){
	try{
		begin();
		getSession().delete(user);
		commit();
		getSession().flush();
	}catch(HibernateException e){
		rollback();
	}
	}
	
	public void updateUser(User user) throws AdException{
		try{
			begin();
			getSession().saveOrUpdate(user);
			commit();
		}catch(HibernateException e){
			rollback();
			throw new AdException("the error cause due tp "+e.getMessage());
		}
		finally{
		  close();
		}
	}
	
	
	
	public List<User> getuUsers() throws AdException{
		try{
			begin();
			Query q = getSession().createQuery("from User");
			List<User> users = q.list();
			commit();
			return users;
		}catch(HibernateException e){
			rollback();
			throw new AdException("the error cause due tp "+e.getMessage());
		}
		finally{
		  close();
		}
		
		
		

		
		
		
	}
	
	public void addcollege(String userID,User euser) throws AdException{
		try{
			begin();
			Query q = getSession().createQuery("from User where userID = :userID");
			q.setString("userID", userID);
			User user = (User)q.uniqueResult();
			euser.getColleagues().add(user);
			user.getColleagues().add(euser);
			getSession().saveOrUpdate(euser);
			getSession().saveOrUpdate(euser);
			
			commit();
			
			
		}catch(HibernateException e){
			rollback();
			throw new AdException("the error cause due tp "+e.getMessage());
		}
		finally{
		  close();
		}
		
	}
	
	public User fetchUser(String userID) throws AdException{
		try{
			begin();
			Query q = getSession().createQuery("from User where userID = :userID");
			q.setString("userID", userID);
			User user = (User)q.uniqueResult();
			return user;
		}catch(HibernateException e){
			rollback();
			throw new AdException("the error cause due tp "+e.getMessage());
		}
		finally{
		  close();
		}
		
	}
	
	public User fetchUser(long userID) throws AdException{
		try{
			begin();
			Query q = getSession().createQuery("from User where userID = :userID");
			q.setLong("userID", userID);
			User user = (User)q.uniqueResult();
			return user;
		}catch(HibernateException e){
			rollback();
			throw new AdException("the error cause due tp "+e.getMessage());
		}
		finally{
		  close();
		}
		
	}
	
	
	
	public Project getProject(Long projectID) throws AdException{
		try{
			begin();
			Query q = getSession().createQuery("from Project where projectID = :projectID ");
            q.setLong("projectID", projectID);            
            Project project = (Project) q.uniqueResult();
            return project;       
            
			
		}catch(HibernateException e){
			rollback();
			throw new AdException("the error cause due tp "+e.getMessage());
		}
		finally{
		  close();
		}
	}
	
	
	
	
	

}
