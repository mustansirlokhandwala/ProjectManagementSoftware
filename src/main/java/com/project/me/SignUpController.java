package com.project.me;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.me.DAO.UserDAO;
import com.project.me.pojo.Address;
import com.project.me.pojo.User;
import com.project.me.pojo.UserAccount;
import com.project.me.pojo.UserRole;


@Controller
public class SignUpController {
	@Autowired
	UserDAO userDAO;
	@Autowired
	User user;
	
	
	@RequestMapping(value="/signup.htm" ,method=RequestMethod.GET)
	public String display(){
		return "signup";
	}
	
	
	@RequestMapping(value="/signup.htm" , method=RequestMethod.POST)
	public ModelAndView signUp(HttpServletRequest request , HttpServletResponse response) throws AdException{
		
		
		
		
		user.setFirstName(request.getParameter("fname"));
		user.setLastName(request.getParameter("lname"));
		user.setCompany(request.getParameter("company"));
		user.setEmail(request.getParameter("email"));
		user.setTitle(request.getParameter("title"));
		user.setPhoneList(Long.parseLong(request.getParameter("phone")));
		
		Address address = new Address();
		address.setStreetName(request.getParameter("street"));
		address.setStateName(request.getParameter("state"));
		address.setCityName(request.getParameter("city"));
		address.setZipCode(Integer.parseInt(request.getParameter("zipcode")));
		address.setUser(user);
		
		user.setAddressList(address);
//		Address ad2 = new Address();
//		ad.setStreetName("second test");
//		ad.setStateName("second test");
//		ad.setCityName("second test");
//		ad.setZipCode(12312);
//		Addresss.add(ad2);
		
		UserAccount ua = new UserAccount();
		
		ua.setUsername(request.getParameter("username"));
		ua.setPassword(request.getParameter("password"));
		ua.setRole(UserRole.ROLE_USER);
		ua.setUser(user);
		user.setUserAccount(ua);
		
		
	    userDAO.addUser(user);
        userDAO.close();
		
		
		

	

		ModelAndView mv = new ModelAndView("home");
		mv.addObject("user", user);
		return mv;
		
		
	}
	
	

}
