package com.project.me;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.me.DAO.MessageDAO;
import com.project.me.DAO.UserAccountDAO;
import com.project.me.pojo.Message;
import com.project.me.pojo.User;
import com.project.me.pojo.UserAccount;



@Controller
public class LoginController {
	@Autowired
	UserAccountDAO userAccountDAO;
	@Autowired
	User user;
	@Autowired
	UserAccount userAccount;
	
	@RequestMapping( value="/login.htm" ,method = RequestMethod.GET)
	public String formView(HttpServletRequest request , HttpServletResponse response){
		
		Long userid = (Long)request.getSession().getAttribute("user");
		if(userid != null){
			request.getSession().removeAttribute("user");
		}
		
	       	
			return "login";
	}
	
	@RequestMapping(value="/login.htm" ,method = RequestMethod.POST)
	public ModelAndView successView(HttpServletRequest request , HttpServletResponse response) throws AdException{
		
		ModelAndView view = new ModelAndView();
		String username =(String) request.getParameter("username");
		String password = (String) request.getParameter("password");
	    userAccount  = userAccountDAO.getUserAccount(username, password);
		userAccountDAO.close();
		if(userAccount == null){
			view.setViewName("login");
			String error = "Username or Password Incorrect";
			view.addObject("error",error);
			return view;
			
		}
			
		user = userAccount.getUser();
		System.out.println(user.getUserID());
		request.getSession().setAttribute("user", user.getUserID());
		view.setViewName("main");
		view.addObject("user", user);
		
		
		return view;
		
	}

}
