package com.project.me.DAO;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.project.me.AdException;
import com.project.me.pojo.Phase;


@Repository
public class PhaseDAO extends DAO {

	
	public void addphase(Phase phase) throws AdException{
		try{
			begin();
			getSession().save(phase);
			commit();
			
		}catch(HibernateException e){
			rollback();
			throw new AdException("the error cause due tp "+e.getMessage());
		}
		finally{
		  close();
		}
	}
}
