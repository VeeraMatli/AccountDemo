package com.idexcel.accountservices.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idexcel.accountservices.Service.AccountDetailsService;

@RestController
@RequestMapping("/accounts")
public class AccountDetailsController {

	@Autowired
	public AccountDetailsService accountDetailsService;
	
	@RequestMapping(path="/{userName}/{password}", method = RequestMethod.GET)
	@ResponseBody
	public String checkLogin(@PathVariable String userName, @PathVariable String password) {
		String jwtToken = "";
		System.out.println("Username -- "+userName+"password -- "+password);
		boolean verify = accountDetailsService.checkLogin(userName, password);
		
		if(verify) {
			
		}
		    
		
		return jwtToken;
	}
}
