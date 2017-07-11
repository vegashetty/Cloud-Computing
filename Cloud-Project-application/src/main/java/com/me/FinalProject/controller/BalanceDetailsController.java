package com.me.FinalProject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.FinalProject.DAO.BalanceDetailsDAO;
import com.me.FinalProject.pojo.BalanceDetails;

@Controller
public class BalanceDetailsController {
	private BalanceDetailsDAO balanceDetailsDAO;
	
	@Autowired
	public void setBalanceDetailsDAO(BalanceDetailsDAO balanceDetailsDAO){
		this.balanceDetailsDAO = balanceDetailsDAO;
	}
	
	@RequestMapping(value= "/BalanceDetails.htm",method= RequestMethod.GET)
    public String addBalancePage(HttpServletRequest request) throws Exception{
		System.out.println("here");
		String userId = (String)request.getSession().getAttribute("userID");
		System.out.println(userId);
		ArrayList<BalanceDetails> ac = new ArrayList<BalanceDetails>();
		 ac =  (ArrayList<BalanceDetails>) balanceDetailsDAO.getBalanceDetails(userId);
		 System.out.println("HI");
		request.setAttribute("ac", ac);
    return "BalanceDetails";
	}
	@RequestMapping(value= "/BalanceDetails.htm",method= RequestMethod.POST)
    public String BalanceDetailsPage(HttpServletRequest request) throws Exception{
		
		return "BalanceDetails";
	}
		
	@RequestMapping(value="/FindAtm.htm" ,method= RequestMethod.GET)
	public String findAtm(){
		return "FindAtm";
	}
    

}
