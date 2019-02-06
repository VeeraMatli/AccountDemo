package com.idexcel.accountservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountDetailsController {

	@Autowired
	public AccountDetailsService accountDetailsService;
		
	@Autowired
	public AccountDetails accInfo;
	
	@RequestMapping(path="/Accounts/{userName}/{password}", method = RequestMethod.GET)
	public AccountDetails checkLogin(@PathVariable String userName, @PathVariable String password) {
		String jwtToken = "";
		System.out.println("Username -- "+userName+"password -- "+password);
		accInfo = accountDetailsService.checkLogin(userName, password);
		
		if(accInfo !=null) {
			jwtToken="Token generated";
		}
		    
		
		return accInfo;
	}
	
	@RequestMapping("/Accounts")
	public Iterable<AccountDetails> getAllAccountDetails() {
		return accountDetailsService.getAllAccountDetails();
	}
}
