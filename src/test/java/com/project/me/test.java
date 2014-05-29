package com.project.me;

import java.util.Date;
import java.util.List;

import com.project.me.DAO.UserAccountDAO;
import com.project.me.DAO.UserDAO;
import com.project.me.pojo.Project;
import com.project.me.pojo.User;
import com.project.me.pojo.UserAccount;

public class test {
	
	public static void main(String args[]) throws AdException{
		
		UserAccountDAO uad = new UserAccountDAO();
		UserAccount ua = uad.getUserAccount("mustan", "mustan");
		User user = ua.getUser();
		Project project = new Project();
		project.setProjectName("Project 1");
		Date d = new Date();
		project.setStartDate(d.toString());
		project.setEndDate(d.toString());
		project.getProjectMembers().add(user);
	
		
		List<Project> list = user.getProjects();
		list.add(project);
		user.setProjects(list);
		UserDAO userdao = new UserDAO();
		userdao.updateUser(user);
		uad.close();
		
		
		
	}

}
