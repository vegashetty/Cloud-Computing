package com.me.FinalProject.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.FinalProject.DAO.AdminDAO;
import com.me.FinalProject.pojo.User;

import javassist.expr.NewArray;

@Controller
public class AdminController {
	private AdminDAO adminDAO;
	
	@Autowired
	public void setAdminDAO(AdminDAO adminDAO){
		this.adminDAO = adminDAO;
	}
//	@RequestMapping(value= "/addUser.htm",method= RequestMethod.GET)
//     public String addUserPage(){
//     return "addUser";
//	}
	@RequestMapping(value= "/Customer.htm",method= RequestMethod.GET)
    public String CustomerPage(){
    return "Customer";
	}
	@RequestMapping(value="/Admin.htm",method=RequestMethod.GET)
	//method to initializehomePage
	public String homePage(){
		return "Admin";
}
	
//	@RequestMapping(value="/addUser.htm",method=RequestMethod.POST)
//public String addUser(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("address") String address,@RequestParam("email") String email,@RequestParam("zipCode") int zipCode,@RequestParam("category") String category,@RequestParam("userID") String UserID,@RequestParam("status") String status,HttpServletRequest request,HttpServletResponse response) throws Exception{
//		User user = adminDAO.saveUser(firstName, lastName, email, address, zipCode, category,UserID,status);
//		
//		JSONObject object = new JSONObject();
//		PrintWriter out = response.getWriter();
//		if(user.getUserID() != null){
//			object.put("useradded", "User with UserID"+ UserID+"is created");
//			out.print(object);
//			return null;	
//		}
//		return null;
//	}
	//Adding logout method
	@RequestMapping(value="/logout.htm",method = RequestMethod.POST)
	public String logOut(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session != null){
			 session.invalidate();
		}
		return "Login";
	}
	@RequestMapping(value="/UpdatePassword.htm",method= RequestMethod.GET)
	public String updatePasswordPage()
	{
		return "UpdatePassword";
	}
	
	@RequestMapping(value="/UpdatePassword.htm",method= RequestMethod.POST)
	public String updateUserPassword(@RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword,
			@RequestParam("securityAns") String securityAns,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		
		HttpSession session = request.getSession();
		String userID = (String) session.getAttribute("userId");
	
		//System.out.println(request.getParameter("userID"));
		int result = adminDAO.updatePassword(userID, oldPassword, newPassword,securityAns);
		if(result>0){
			JSONObject object = new JSONObject();
			object.put("updateMessage","Password Updated Successfully");
			PrintWriter out = response.getWriter();
			out.print(object);
	
		}
		session.invalidate();
		return null;
	}
	
	@RequestMapping(value="/BlockUser.htm",method = RequestMethod.GET)
	 public String loadBlockUser(){
		 return "BlockUser";
	 }
	
	
	@RequestMapping(value="/BlockUser.htm",method=RequestMethod.POST)
	public String  blockUser(@RequestParam("userID")String userID, HttpServletResponse response)throws Exception{
		int result = adminDAO.blockUser(userID);
		JSONObject object = new JSONObject();
		PrintWriter out =response.getWriter();
		if(result>0){
			object.put("blockmessage","User with userID " +userID + " is blocked");
			out.print(object);
			return null;
		}else{
		object.put("blockmessage","User with userID " + userID + " cannot be blocked");
		out.print(object);
		return null;
			
		}
	}
	@RequestMapping(value="/ForgotPassword.htm",method= RequestMethod.GET)
	public String forgotPasswordPage()
	{
		return "ForgotPassword";
	}
	
	@RequestMapping(value="/ForgotPassword.htm",method= RequestMethod.POST)
	public String forgotUserPassword(@RequestParam("newPassword") String newPassword,@RequestParam("userID")String userID,
			@RequestParam("securityAns") String securityAns,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
    int result = adminDAO.forgotPassword(userID, newPassword, securityAns);
    
    JSONObject object = new JSONObject();
    PrintWriter out = response.getWriter();
    
    if(result>0){
			
			object.put("updateMessage","New Password Updated Successfully");
			
			out.print(object);
			return null;
	
		}else{
			object.put("updateMessage","Could not update the password");
			out.print(object);
			return null;
			
			
		}
		
		
	}
	
}
