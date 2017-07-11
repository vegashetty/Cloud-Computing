package com.me.FinalProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.FinalProject.DAO.CustomerTransactionDAO;
import com.me.FinalProject.DAO.UserDAO;
import com.me.FinalProject.pojo.AccountDetails;
import com.me.FinalProject.pojo.User;

@Controller
@RequestMapping("/Login.htm")
public class LoginController {
	@Autowired
	@Qualifier("userValidator")
	UserValidator userValidator;
	CustomerTransactionDAO customerDAO;
	UserDAO userDAO;
	@Autowired 
	public void setDAO(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	@Autowired
	public void setCustomerDAO(CustomerTransactionDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest request) throws Exception {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "Login";
		} else {
			
			User validUser = userDAO.getCredentialsValidated(user.getUserID(), user.getPassword());
			if (validUser.getCategory().equalsIgnoreCase("admin")) {
				HttpSession session = request.getSession(true);
				session.setAttribute("adminUser", user.getFirstName());
				
				return "Admin";
			} else if(validUser.getCategory().equalsIgnoreCase("customer")) {
				if(validUser.getPassword().equalsIgnoreCase("241289")){
					HttpSession session = request.getSession(true);
					session.setAttribute("userId",validUser.getUserID());
					return "UpdatePassword";
				}else{
				HttpSession session = request.getSession(true);
				session.setAttribute("userID", user.getUserID());
		
				//List<Object[]> list =  customerDAO.getCustomerBalance(user);
//				for(Object[] ac:  list){
//				request.setAttribute("accounttype", (String) ac[0]);
//				request.setAttribute("balance",String.valueOf(ac[1]));
//				}
				return "Customer";}
			}else{
				return null;
			}
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public String intializeForm(@ModelAttribute("user") User user, BindingResult result) {
		return "Login";
	}
	


}
