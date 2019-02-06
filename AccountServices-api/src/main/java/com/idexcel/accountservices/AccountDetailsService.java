package com.idexcel.accountservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailsService {

	@Autowired
	public AccountDetailsRepository accountDetailsRepository;
	@Autowired
	public AccountDetails accountDetails;
	
	
	public AccountDetails checkLogin(String userName, String password) {

		accountDetails = accountDetailsRepository.findByUserName(userName);
		System.out.println("userVerified -- "+accountDetails.getFirstName());
		
	//	boolean pwdVerified = accountDetailsRepository.findByPassword(password);
	//	System.out.println("userVerified -- "+userVerified);
		
		if(accountDetails.getEmail() !=null && accountDetails.getFirstName() !=null) {
			return accountDetails;
		} else { 
			
			System.out.println("Unable to find User. Please check User Name and Password.");
			return new AccountDetails();
		}
	}
	
	
	public Iterable<AccountDetails> getAllAccountDetails() {
		return accountDetailsRepository.findAll();
	}
}
