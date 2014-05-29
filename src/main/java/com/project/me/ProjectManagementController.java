package com.project.me;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class ProjectManagementController {
	
	@Autowired
	User user;
	@Autowired
	UserDAO userDAO;
	@Autowired
	ProjectDAO projectDAO;
	@Autowired
	PhaseDAO phaseDAO;
	
	
	@RequestMapping(value="/getphase.htm" , method=RequestMethod.GET)
	public ModelAndView getPhases(HttpServletRequest request , HttpServletResponse response) throws AdException{
		ModelAndView mv = new ModelAndView();
		long userid = (Long)request.getSession().getAttribute("user");
		user = userDAO.fetchUser(userid);
		String id = String.valueOf(user.getUserID());
		User currentuser = userDAO.fetchUser(id);
		mv.setViewName("addphases");
		mv.addObject("projectlist" ,currentuser.getProjects());
		return mv;	
		
	}
	
	@RequestMapping(value="/addphase.htm" , method = RequestMethod.POST)
	public ModelAndView addPhases(HttpServletRequest request , HttpServletResponse response) throws AdException{
		
		long userid = (Long)request.getSession().getAttribute("user");
		user = userDAO.fetchUser(userid);
		ModelAndView mv = new ModelAndView();
		String[] phases = request.getParameterValues("phasename");
		String[] startdates = request.getParameterValues("startdate");
		String[] enddates = request.getParameterValues("enddate");
		Project project =(Project)request.getSession().getAttribute("project");
		for(int i = 0 ; i< phases.length ; i ++){
			Phase phase = new Phase();
			phase.setPhaseName(phases[i]);
			Date d = new Date();
			phase.setStartDate(d);
			phase.setEndDate(d);
			phase.setProject(project);
			phaseDAO.addphase(phase);
			
			
		}
		System.out.println(project.getProjectName());
	    mv.addObject("user",user);
		mv.setViewName("main");
	    return mv;
		
		
	}
	
	
	@RequestMapping(value="/addteam" , method= RequestMethod.GET)
	public ModelAndView addteam(HttpServletRequest request ,HttpServletResponse response) throws AdException{
ModelAndView mv = new ModelAndView();
		
long userid = (Long)request.getSession().getAttribute("user");
user = userDAO.fetchUser(userid);
		List<Project> prolist = user.getProjects();
		Set<User> userlist = user.getColleagues();		
		mv.addObject("prolist",prolist.toArray());
		
	mv.setViewName("addprojectmates");
		return mv;
		
	}
	
	@RequestMapping(value="/projectmateedit.htm" , method = RequestMethod.GET)
	public ModelAndView editteammates(HttpServletRequest request , HttpServletResponse response) throws AdException{
		long userid = (Long)request.getSession().getAttribute("user");
		user = userDAO.fetchUser(userid);
		ModelAndView mv = new ModelAndView();
		Long p =(Long)request.getSession().getAttribute("projectid");
		request.getSession().removeAttribute("projectid");
		System.out.println(p);
		String addid = request.getParameter("addid");
		User user2 = userDAO.fetchUser(addid);
		Project project2 = (Project) userDAO.getProject(p);
		
		user2.getProjects().add(project2);		
		userDAO.getSession().update(user2);
		
		
		
		project2 .getProjectMembers().add(user2);
		projectDAO.updateProject(project2);
		mv.addObject("user",user);
		mv.setViewName("main");
		return mv;
	}
	
	
	@RequestMapping(value="/projectmates" , method = RequestMethod.GET)
	public void people(HttpServletRequest request,Model model,HttpServletResponse response) throws IOException, AdException{
		long userid = (Long)request.getSession().getAttribute("user");
		user = userDAO.fetchUser(userid);
		String project =  request.getParameter("project");
		String addid=request.getParameter("addid");
		if(addid != null){
			System.out.println(addid);
		}
		else{
			System.out.println("Null found !!!!!!!");
		}
		System.out.println(project);
		String returnString="";
		Project p = projectDAO.getProject(project);	
		projectDAO.close();
		request.getSession().setAttribute("projectid", p.getProjectID());
		Set<User> userlist = user.getColleagues();
		for(User u : p.getProjectMembers()){
			for(User u2 :userlist){
				if(u.getUserID() ==u2.getUserID()){
					userlist.remove(u2);
				}
			}
				
		}
		p.getProjectName();
		response.getWriter().println("<div class='container'");
		response.getWriter().println("<div class='row'>" );
		response.getWriter().println("<label class='label-control'>Project Memebers</label> ");
		response.getWriter().println("</div>" );
		response.getWriter().println("<br>");
		response.getWriter().println("<div class='row'>");
		response.getWriter().println("<table class='table'>" );
		response.getWriter().println("<tr>");
		response.getWriter().println("<th>First Name</th>");
		response.getWriter().println("<th>Last  Name</th>");
		response.getWriter().println("<th>Company Name</th>");
		response.getWriter().println("<th>Remove from Project</th>");
		response.getWriter().println("</tr>");
		for(User u :p.getProjectMembers()){
			returnString+= u .getFirstName() ;
			
			
		System.out.println(returnString);
		if(returnString.equals("")){
			
			response.getWriter().println("<p>No Team Mates for This Project</p>");
		}
		else{
			response.getWriter().println("<tr>");
			response.getWriter().println("<td>"+u.getFirstName()+"<td>");
			response.getWriter().println("<td>"+u.getLastName()+"<td>");
			response.getWriter().println("<td>"+u.getCompany()+"<td>");
			response.getWriter().println("<td><a href='projectmateedit.htm?removeid="+u.getUserID()+"'>Remove</a></td>");
			response.getWriter().println("</tr>");
		}
		
		
		
		}
		response.getWriter().println("</table>");
		response.getWriter().println("</div>");
		response.getWriter().println("<br>");
		response.getWriter().println("<div class='row'>" );
		response.getWriter().println("<label class='label-control'>Collegues</label> ");
		response.getWriter().println("</div>" );
		response.getWriter().println("<br>");
		response.getWriter().println("<table class='table'>" );
		response.getWriter().println("<tr>");
		response.getWriter().println("<th>First Name</th>");
		response.getWriter().println("<th>Last  Name</th>");
		response.getWriter().println("<th>Company Name</th>");
		response.getWriter().println("<th>Add to Project</th>");
		response.getWriter().println("</tr>");
		for(User u :userlist){
			returnString+= u .getFirstName() ;
			
			
		System.out.println(returnString);
		if(returnString.equals("")){
			
			response.getWriter().println("<p>No Friends</p>");
		}
		else{
			response.getWriter().println("<tr>");
			response.getWriter().println("<td>"+u.getFirstName()+"<td>");
			response.getWriter().println("<td>"+u.getLastName()+"<td>");
			response.getWriter().println("<td>"+u.getCompany()+"<td>");
			response.getWriter().println("<td><a href='projectmateedit.htm?addid="+u.getUserID()+"'>Add</a></td>");
			response.getWriter().println("</tr>");
		}
		
		
		
		}
		response.getWriter().println("</table>");
		response.getWriter().println("</div>");

		
	}
	
	

}
