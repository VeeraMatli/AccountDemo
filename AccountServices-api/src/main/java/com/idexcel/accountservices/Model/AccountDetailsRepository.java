package com.idexcel.accountservices.Model;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.idexcel.accountservices.Beans.AccountDetails;

public interface AccountDetailsRepository  extends MongoRepository<AccountDetails, String>{
	
	

}
