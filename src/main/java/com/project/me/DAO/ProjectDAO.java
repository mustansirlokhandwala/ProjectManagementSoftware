package com.project.me.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.project.me.AdException;
import com.project.me.pojo.Project;
import com.project.me.pojo.UserAccount;



@Repository
public class ProjectDAO extends DAO {
	
	
	public void createProject(Project project){
		try{
		begin();
		getSession().save(project);
	    commit();
		}catch(HibernateException e){
			rollback();
		}
	}
	
	public void updateProject(Project project){
		try{
		begin();
		getSession().saveOrUpdate(project);
	    commit();
		}catch(HibernateException e){
			rollback();
		}
	}
	
	public void mergeProject(Project project){
		try{
		begin();
		getSession().merge(project);
	    commit();
		}catch(HibernateException e){
			rollback();
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
	
	public Project getProject(String projectName) throws AdException{
		try{
			begin();
			Query q = getSession().createQuery("from Project where projectName = :projectName ");
            q.setString("projectName", projectName);            
            Project project = (Project) q.uniqueResult();
            return project;       
            
			
		}catch(HibernateException e){
			throw new AdException("the error cause due tp "+e.getMessage());
		}
		finally{
		  close();
		}
	}

}
