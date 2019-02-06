package com.idexcel.accountservices;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountDetailsRepository  extends MongoRepository<AccountDetails, String>{
	
	AccountDetails findByUserName(String userName);
	AccountDetails findByPassword(String password);

}
