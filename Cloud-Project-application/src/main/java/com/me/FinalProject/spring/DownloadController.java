package com.me.FinalProject.spring;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.FinalProject.DAO.BalanceDetailsDAO;
import com.me.FinalProject.pojo.BalanceDetails;

@Controller
public class DownloadController {
private BalanceDetailsDAO balanceDetailsDAO;
	
	@Autowired
	public void setBalanceDetailsDAO(BalanceDetailsDAO balanceDetailsDAO){
		this.balanceDetailsDAO = balanceDetailsDAO;
	}
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String viewCustomer() {
	        return "Customer";
	    }
	 
	 @RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
	    public ModelAndView downloadExcel(HttpServletRequest request) throws Exception {
	       
		 System.out.println("here");
			String userId = (String)request.getSession().getAttribute("userID");
			System.out.println(userId);
			ArrayList<BalanceDetails> ac = new ArrayList<BalanceDetails>();
			 ac =  (ArrayList<BalanceDetails>) balanceDetailsDAO.getBalanceDetails(userId);
			 System.out.println("HI");
			request.setAttribute("ac", ac);
	   
	 
	       
	        return new ModelAndView("pdfView", "ac", ac);
	    }

}
