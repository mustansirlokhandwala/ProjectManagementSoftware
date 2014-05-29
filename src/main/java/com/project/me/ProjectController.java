package com.project.me;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.me.DAO.PhaseDAO;
import com.project.me.DAO.ProjectDAO;
import com.project.me.DAO.UserDAO;
import com.project.me.pojo.Phase;
import com.project.me.pojo.Project;
import com.project.me.pojo.User;


@Controller
public class ProjectController {
	
	@Autowired
	Project project;
	@Autowired
	ProjectDAO projectDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    User user;
    @Autowired
    PhaseDAO phasedao;
    
	@RequestMapping(value="/project.htm" , method=RequestMethod.GET)
	public String project(){
		
		return "createproject";
	
	}
	
	@RequestMapping(value="/addproject.htm",method=RequestMethod.POST)
	public ModelAndView addproject(HttpServletRequest request ,HttpServletResponse response) throws AdException{
		
		long userid = (Long)request.getSession().getAttribute("user");
		user = userDAO.fetchUser(userid);
		project.setProjectName(request.getParameter("pname"));		
		project.setStartDate(request.getParameter("sdate"));
		project.setEndDate(request.getParameter("edate"));
		project.setType(request.getParameter("ptype"));
		System.out.println(request.getParameter("pname"));
		System.out.println(request.getParameter("sdate"));
		System.out.println(request.getParameter("edate"));
		System.out.println(request.getParameter("ptype"));
	 
		
		user.getProjects().add(project);
		project.getProjectMembers().add(user);
		projectDAO.createProject(project);
		
		userDAO.updateUser(user);		
		userDAO.close();
		projectDAO.close();
		String[] phases = request.getParameterValues("phasename");
		String[] startdates = request.getParameterValues("startdate");
		String[] enddates = request.getParameterValues("enddate");
		
		for(int i = 0 ; i< phases.length ; i ++){
			Phase phase = new Phase();
			phase.setPhaseName(phases[i]);
			Date d = new Date();
			phase.setStartDate(d);
			phase.setEndDate(d);
			phase.setProject(project);
			phasedao.addphase(phase);
			phasedao.close();
			
		}
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("user",user);
		mv.setViewName("main");
		return mv;
		
		
	}
	
	@RequestMapping(value="/viewproject.htm",method=RequestMethod.GET)
	public ModelAndView viewProjects(HttpServletRequest request , HttpServletResponse response) throws AdException{
		ModelAndView mv = new ModelAndView();
		
		long userid = (Long)request.getSession().getAttribute("user");
		user = userDAO.fetchUser(userid);
		List<Project> prolist = user.getProjects();
		mv.addObject("prolist",prolist.toArray());
		mv.setViewName("viewprojects");
		
		return mv;
	}
	
//	@RequestMapping(value="/addteam.htm", method=RequestMethod.GET)
//	public ModelAndView addTeamMates(HttpServletRequest request , HttpServletResponse response){
//	   ModelAndView mv = new ModelAndView();
//	   long pid = Long.parseLong(request.getParameter("project"));
//	   
//	   project = projectDAO.getProject(pid);
//	   System.out.println(project.getProjectName());
//	   mv.setViewName("main");
//	    return mv;
//	
//	}
	
	

}
