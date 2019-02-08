package com.idexcel.accountservices.AccountServicesapi;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AccountDetailsController {

	@Autowired
	public AccountDetailsService accountDetailsService;

	@RequestMapping(path = "/login/{userName}/{password}", method = RequestMethod.GET)
	public String checkLogin(@PathVariable String userName, @PathVariable String password) {
		String jwtToken = "";
		System.out.println("Username -- " + userName + " password -- " + password);
		AccountDetails accountDetails = accountDetailsService.checkLogin(userName, password);

		if (accountDetails != null) {
			jwtToken = Jwts.builder().setSubject(userName).claim("roles", "user").setIssuedAt(new Date())
					.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
			
			/** Parsing token and reading it.*/
			JwtParser parsedJwt = Jwts.parser().setSigningKey("secretkey");
			System.out.println(parsedJwt);
			Jwt finalToken = parsedJwt.parse(jwtToken);
			System.out.println("finaltoken body----"+finalToken.getBody().toString());
			/** This is end of parsing. */ 
		}
		System.out.println("jwtToken -- " + jwtToken);
		return jwtToken;
	}
	
	@RequestMapping(path="/logout", method = RequestMethod.GET)
	public void logout() {
		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/Accounts")
	public ResponseEntity<List<AccountDetails>> getAllAccountDetails(HttpServletResponse response) {
		List<AccountDetails> detailsList =accountDetailsService.getAllAccountDetails();
		if(detailsList == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<List<AccountDetails>>(detailsList,header, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/Accounts/add", method = RequestMethod.POST)
	public String addDetails(@RequestBody AccountDetails details) {
		accountDetailsService.save(details);
		return details.getAccountId();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Accounts/{userName}")
	public AccountDetails getAccountDetails(@PathVariable String userName) {
		return accountDetailsService.getAccountDetails(userName);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/Accounts/{userName}")
	public String putAccountDetails(@RequestBody AccountDetails details) {
		accountDetailsService.save(details);
		return details.getAccountId();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/Accounts/{userName}")
	public String deleteAccount(@PathVariable String userName) {
		accountDetailsService.deleteUser(userName);
		return "Account Deleted";
	}
	
	@RequestMapping(method = RequestMethod.PATCH, value = "/Accounts/{userName}")
	public String patchAccountDetails(@RequestBody AccountDetails details, @PathVariable String userName) {
		accountDetailsService.patchUser(details, userName);
		return details.getAccountId();
	}

	
}
