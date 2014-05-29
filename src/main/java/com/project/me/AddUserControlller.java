package com.project.me;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.me.DAO.AddRequestDAO;
import com.project.me.DAO.ProjectDAO;
import com.project.me.DAO.UserAccountDAO;
import com.project.me.DAO.UserDAO;
import com.project.me.pojo.AddRequest;
import com.project.me.pojo.Project;
import com.project.me.pojo.User;
import com.project.me.pojo.UserAccount;

@Controller
public class AddUserControlller {
	
	
	@Autowired
	UserDAO userdao;
	@Autowired
	ProjectDAO projectdao;
	@Autowired
	AddRequestDAO addResquestdao;
	@Autowired
	UserAccountDAO userAccoundao;
	@Autowired
	User user;
	
	
	@RequestMapping( value="/searchuser.htm" ,method = RequestMethod.GET)
	public ModelAndView mainView(HttpServletRequest request , HttpServletResponse response) throws AdException{
		
		List<User> userlist = userdao.getuUsers();
		
		userdao.close();
		
		long userid = (Long)request.getSession().getAttribute("user");
		user = userdao.fetchUser(userid);
		User remove = null;
		for(User u : userlist){
			if(user.getUserID() == u.getUserID())
				remove = u;
		}
		userlist.remove(remove);
		System.out.println(user.getFirstName());
		ModelAndView mv = new ModelAndView();
		mv.addObject("userlist",userlist);
		mv.setViewName("addcollegue");
		return mv;
		
	}
	
	@RequestMapping( value="/adduser.htm" ,method = RequestMethod.GET)
	public String SearchView(){
		
		return "addcollegue";
		
	}
	
	@RequestMapping(value="/addrequest.htm" , method = RequestMethod.GET)
	public void addRequest(HttpServletRequest request , HttpServletResponse response) throws AdException{
		
		String id = request.getParameter("name");		
		
		
		
		long userid = (Long)request.getSession().getAttribute("user");
		user = userdao.fetchUser(userid);
		
		
		UserAccount userAccount = user.getUserAccount();
		
		AddRequest addRequest = new AddRequest();
		addRequest.setFromUser(userAccount);
		addRequest.setToUser(id);
		addRequest.setRequesteddate("24/09/90");
		
		
		userAccount.getOutrequest().add(addRequest);
		System.out.println(addRequest.getFromUser().getUsername());
		System.out.println(addRequest.getToUser());
		System.out.println(addRequest.getRequesteddate());
		
		
		userAccoundao.update(userAccount);
		
        userAccoundao.close();
        	
        
		
		
		
		
	}
	
	@RequestMapping( value="/add.htm" ,method = RequestMethod.GET)
	public ModelAndView SearchView(HttpServletRequest request , HttpServletResponse response) throws AdException{
		
		long id = Long.parseLong(request.getParameter("name"));
		
	    System.out.println(id);
	    AddRequest addRequest = addResquestdao.getRequest(id);
	    addResquestdao.close();
	    addRequest.getId();
		
		User fromuser = addRequest.getFromUser().getUser();
		String touserid = addRequest.getToUser();
		User touser = userdao.fetchUser(touserid);
		userdao.close();
//		User fromuser = userdao.fetchUser(fromuserid);
		userdao.close();
		fromuser.getColleagues().add(touser);
		touser.getColleagues().add(fromuser);
		fromuser.getUserAccount().getOutrequest().remove(addRequest);		
		userdao.updateUser(fromuser);
		userdao.updateUser(touser);
		userdao.close();
		fromuser.getUserAccount().getOutrequest().remove(addRequest);
		userAccoundao.update(fromuser.getUserAccount());
		
		
		ModelAndView mv = new ModelAndView("viewuser");
		mv.addObject("userlist",user.getColleagues());
		
		return mv;
	}
	
	@RequestMapping(value = "/viewuser.htm",method=RequestMethod.GET)
	public ModelAndView viewuser(HttpServletRequest request , HttpServletResponse response) throws AdException{
		
		ModelAndView mv = new ModelAndView();
		long userid = (Long)request.getSession().getAttribute("user");
		user = userdao.fetchUser(userid);
		mv.setViewName("viewuser");
		mv.addObject("userlist",user.getColleagues());
		return mv;
		
		
	}
	
	@RequestMapping( value="/removeuser.htm" ,method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest request , HttpServletResponse response) throws AdException{
		
		
		
		
		
		long userid = (Long)request.getSession().getAttribute("user");
		user = userdao.fetchUser(userid);
		
		Set<User> list = user.getColleagues();
		for(User u : list){
			u.getTeammates().remove(user);
			user.getColleagues().remove(u);
			userdao.updateUser(u);
			userdao.updateUser(user);
		}
		
		
		
		List<Project> projects = user.getProjects();
		for(Project project : projects){
			project.getProjectMembers().remove(user);
			projectdao.updateProject(project);
			
		}
		user.getProjects().removeAll(projects);
		userdao.updateUser(user);
		userdao.deleteUser(user);
		
		return "login";
		
	}
	
	@RequestMapping(value="/viewrequest.htm",method=RequestMethod.GET)
	public ModelAndView viewrequest(HttpServletRequest request , HttpServletResponse response) throws AdException{
		ModelAndView mv = new ModelAndView();
		
		long userid = (Long)request.getSession().getAttribute("user");
		user = userdao.fetchUser(userid);
		String id = String.valueOf(user.getUserID());
		System.out.println(id);
		List<AddRequest> addrequestlist = addResquestdao.getALLRequest();
		List<AddRequest> requestlist = new ArrayList<AddRequest>();
		for(AddRequest ar : addrequestlist){
			System.out.println("touser"+ar.getToUser());
			if(ar.getToUser().equals(id))
			{
				requestlist.add(ar);
			}
		}
		mv.addObject("requestlist",requestlist);
		mv.setViewName("viewrequest");
		return mv;
	}
	
	

}
