package com.idexcel.accountservices.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idexcel.accountservices.Beans.AccountDetails;
import com.idexcel.accountservices.Model.AccountDetailsRepository;

@Service
public class AccountDetailsService {

	@Autowired
	public AccountDetailsRepository accountDetailsRepository;
	
	
	public boolean checkLogin(String userName, String password) {
		boolean loginVerified = false;

		Optional<AccountDetails> userVerified = accountDetailsRepository.findById(userName);
		System.out.println("userVerified -- "+userVerified);
		
		
				    

		return loginVerified;
	}
}
