package com.me.FinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.FinalProject.DAO.UserDAO;
import com.me.FinalProject.pojo.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class aClass) {
		// TODO Auto-generated method stub
		return aClass.equals(User.class);
	}
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	public void setDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	@Override
	public void validate(Object object, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User) object;
		ValidationUtils.rejectIfEmpty(errors, "userID", "UserID cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "Password cannot be empty");
		
		try {
			User validUser = userDAO.getCredentialsValidated(user.getUserID(), user.getPassword());
			if(validUser.getUserID() == null){
				errors.reject("Username not found");;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
