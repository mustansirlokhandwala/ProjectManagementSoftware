package com.project.me;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.me.DAO.MessageDAO;
import com.project.me.DAO.UserAccountDAO;
import com.project.me.DAO.UserDAO;
import com.project.me.pojo.Message;
import com.project.me.pojo.User;
import com.project.me.pojo.UserAccount;


@Controller
public class MessageController {
	
	@Autowired
	User user;
	
	@Autowired
	UserAccountDAO userAccountdao;
	
	@Autowired
	MessageDAO messagedao;
	
	@Autowired 
	UserDAO userDAO;
	
	@RequestMapping(value="/message.htm" , method=RequestMethod.GET)
	public ModelAndView displayMessage(HttpServletRequest request , HttpServletResponse response) throws AdException{
		ModelAndView mv = new ModelAndView();
		
		long userid = (Long)request.getSession().getAttribute("user");
		user = userDAO.fetchUser(userid);
		UserAccount userAccount = userAccountdao.getUserAccount(user);
		System.out.println(userAccount.getUsername());
		List<Message> list = messagedao.getUserAccount(userAccount.getUsername());
        List<Message> messagelist = new ArrayList<Message>();
		for(Message m : list)
			if(m.getToUserAccount().equals(userAccount.getUsername()))
				messagelist.add(m);
		mv.addObject("messagelist",messagelist);
		mv.setViewName("message");
	    
		return mv;
		
		
		
		
		
		
	}

}
