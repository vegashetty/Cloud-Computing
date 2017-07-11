package com.me.FinalProject.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.FinalProject.DAO.CustomerTransactionDAO;
import com.me.FinalProject.pojo.AccountDetails;
import com.me.FinalProject.pojo.AddBeneficiary;
import com.me.FinalProject.pojo.BalanceDetails;
import com.me.FinalProject.pojo.TranferDetails;

@Controller
public class TransferController {
	CustomerTransactionDAO customerDAO;
	
	@Autowired
	public void setCustomerDAO(CustomerTransactionDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	@RequestMapping(value="/Transfer.htm",method=RequestMethod.GET)
	public String loadTransferPage(){
		return "Transfer";
	}
	@RequestMapping(value= "/AddPayee.htm",method= RequestMethod.GET)
    public String addPayeePage(){
		
    return "AddPayee";
	}
	
	@RequestMapping(value= "/AddPayee.htm",method= RequestMethod.POST)
    public String addPayee(@RequestParam("userID")String userID,@RequestParam("addAccount") String addAccount, HttpServletResponse response,HttpServletRequest request) throws Exception{
	
		
		
		String username = (String) request.getSession().getAttribute("userId");
		System.out.println(username);
	List<AccountDetails> accountDetails	= new ArrayList<AccountDetails>();
	long acNo = 0;
	for(AccountDetails ac : accountDetails){
	 acNo= ac.getAccountNo();
	}
	Long addC = Long.parseLong(addAccount);
	AddBeneficiary ad = customerDAO.addBeneficary(userID,acNo,addC);
	JSONObject object = new JSONObject();
	PrintWriter out = response.getWriter();
	if(ad!=null){
		object.put("accountAdded", "Payee Account Added successfully");
		out.print(object);
		return null;	
	}
	else{
		object.put("accountAdded", "Payee Account Cannot be Added ");
		out.print(object);
		return null;
	}
    
}
	@RequestMapping(value="/MakeTransfer.htm",method=RequestMethod.GET)
	public String loadMakeTranferPage(HttpServletRequest request){
		String userID = (String) request.getSession().getAttribute("userID");
		System.out.println(userID);
		ArrayList<AddBeneficiary> addBen = new ArrayList<AddBeneficiary>();
		addBen = (ArrayList<AddBeneficiary>) customerDAO.addBenefica(userID);
		for(AddBeneficiary ad : addBen){
			System.out.println(ad);
		}
		request.setAttribute("benficaList",addBen);
		return "MakeTransfer";
	}
	
	@RequestMapping(value="/MakeTransfer.htm",method=RequestMethod.POST)
	public String MakeTransferPage(HttpServletRequest request,@RequestParam("fromAC") String fromAccount,@RequestParam("toAC") String toAC,@RequestParam("amount") String amount,@RequestParam("description") String description){
	long from = Long.parseLong(fromAccount);
	long to = Long.parseLong(toAC);
	float am = Float.parseFloat(amount);
	String userID = (String) request.getSession().getAttribute("userID");
	TranferDetails ts = customerDAO.saveTransfer(from, to, am, description, userID);
   BalanceDetails bd = customerDAO.addtransferDetails(description, am, am,userID );
	if(ts!=null){
		return "success";
	}else{
		return "failure";
	}
	}
}