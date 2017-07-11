package com.me.FinalProject.controller;

import java.io.PrintWriter;
import java.io.Reader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.FinalProject.DAO.AdminDAO;
import com.me.FinalProject.pojo.User;

@Controller
public class StartupController {
	//to load signup page
	@RequestMapping(value="/addUser.htm", method = RequestMethod.GET)
	public String loadSignUpPage(){
		return "addUser";
	}
private AdminDAO adminDAO;
	
	@Autowired
	public void setAdminDAO(AdminDAO adminDAO){
		this.adminDAO = adminDAO;
	}
	@RequestMapping(value="/addUser.htm",method=RequestMethod.POST)
public String addUser(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("address") String address,@RequestParam("email") String email,@RequestParam("zipCode") int zipCode,@RequestParam("category") String category,@RequestParam("userID") String UserID,@RequestParam("status") String status,HttpServletRequest request,HttpServletResponse response) throws Exception{
		User user = adminDAO.saveUser(firstName, lastName, email, address, zipCode, category,UserID,status);
			
			JSONObject object = new JSONObject();
			PrintWriter out = response.getWriter();
		if(user.getUserID() != null){
			object.put("useradded", "User with UserID " + UserID+ "is created, with password " + user.getPassword());
			out.print(object);				return null;	
			}
		return null;
	}
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String returnLogin(@ModelAttribute("user") User user){
		return "Login";
	}
}
