package com.project.me.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.me.AdException;
import com.project.me.pojo.User;
import com.project.me.pojo.UserAccount;

@Repository
public class UserAccountDAO extends DAO {
	

	public  UserAccount getUserAccount(String username , String password) throws AdException{
		
		    try {
		            begin();
		            Query q = getSession().createQuery("from UserAccount where username = :username and password= :password");
		            q.setString("username", username);
		            q.setString("password", password);
		            UserAccount userAccount = (UserAccount) q.uniqueResult();		           
		            commit();
		            return userAccount;
		        } catch (HibernateException e) {
		            rollback();
		        	throw new AdException("the error cause due tp "+e.getMessage());
				}
				finally{
				  close();
				
		        
		        }
		    
	}
	public  UserAccount getUserAccount(User user) throws AdException{
		
	    try {
	            begin();
	            Query q = getSession().createQuery("from UserAccount where user = :user");
	            q.setEntity("user", user);	            
	            UserAccount userAccount = (UserAccount) q.uniqueResult();		           
	            commit();
	            return userAccount;
	        } catch (HibernateException e) {
	            rollback();
	        	throw new AdException("the error cause due tp "+e.getMessage());
			}
			finally{
			  close();
			}
	    
}
	public  UserAccount getUserAccount(long id) throws AdException{
		
	    try {
	            begin();
	            Query q = getSession().createQuery("from UserAccount where id = :id ");
	            q.setLong("id", id);	            
	            UserAccount userAccount = (UserAccount) q.uniqueResult();		           
	            commit();
	            return userAccount;
	        } catch (HibernateException e) {
	            rollback();
	        	throw new AdException("the error cause due tp "+e.getMessage());
			}
			finally{
			  close();
			}
	    
}
	
	
	public void update(UserAccount userAccount){
		try{
			begin();
			getSession().saveOrUpdate(userAccount);
			commit();
			getSession().flush();
		}catch(HibernateException e){
			rollback();
		}
	}

}
