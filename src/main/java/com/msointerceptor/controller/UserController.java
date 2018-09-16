package com.msointerceptor.controller;

import static org.mockito.Mockito.RETURNS_MOCKS;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msointerceptor.exceptions.CustomException;
import com.msointerceptor.model.Quote;
import com.msointerceptor.model.User;
import com.msointerceptor.repository.QuoteRepository;
import com.msointerceptor.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserRepository userRepo; 
	
	@Autowired
	QuoteRepository quoteRepo;

	/**
	 * GET ALL ALERTS
	 * @return
	 */
	@GetMapping("")
	public List<User> 
	getAllUsers() 
	{
	    return userRepo.findAll();
	}

	
	/**
	 * Add a New Alert
	 * @param alert
	 * @return
	 */
	@PostMapping("/add")
	public List<User> 
	createUser( @Valid @RequestBody User user)
	{
		System.out.println("User--"+user.toString());
		
		//User user = userArg;
		List<Quote> quoteList= user.getUserQuote();
		
		System.out.println("quote--"+user.getUserQuote().toString());
		
		//user.getUserQuote().addAll(quoteList);
		System.out.println("quote 2--"+user.toString());
		
		quoteList
			.forEach(
				quote->{
					quote.setQuotesUser(user);
				});
		System.out.println("User 1--"+user.getUserQuote().get(0).getUserName());
		User newUser = userRepo.saveAndFlush(user);
		System.out.println("User 1--"+newUser.getName());
		/*
		user.getUserQuote()
		.forEach(quote-> {
			System.out.println("User--"+newUser.toString());
			quote.setQuotesUser(newUser);
			quoteRepo.saveAndFlush(quote);
		});*/
			
	   return  this.getAllUsers();
	}
	
	/**
	 * Update a Alert
	 * @param alertId
	 * @param alertDetails
	 * @return
	 */
	@PutMapping("/update/{id}")
	public List<User>  
	updateUser(@PathVariable(value = "id") int userId,
	           @Valid @RequestBody User userDetails) 
	{
		
		User user = userRepo
					 .findById(userId)
					 .orElseThrow(()-> new CustomException("User", "id", userId,HttpStatus.NOT_FOUND));

		user.setEmailAddress(userDetails.getEmailAddress());
		user.setName(userDetails.getName());
		userRepo.saveAndFlush(user);

	    return getAllUsers();
	}
	
	/**
	 * Get Single alert deatials
	 * @param alertId
	 * @return
	 */
	@GetMapping("get/{id}")
	public User 
	getUserById(@PathVariable(value = "id") int userId)
	{
	    return userRepo.findById(userId)
	    		.orElseThrow(()-> new CustomException("User", "id", userId,HttpStatus.NOT_FOUND));
	}

	/**
	 * delete alert by Id
	 * @param alertId
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public List<User> 
	deleteUser(@PathVariable(value = "id") int userId) 
	{
		User alert = userRepo
				             .findById(userId)
				             .orElseThrow(()-> new CustomException("User", "id", userId,HttpStatus.NOT_FOUND));
		
		userRepo.delete(alert);

	    return getAllUsers();
	}
	
	@DeleteMapping("/delete/all")
	public List<User> 
	deleteAll() 
	{
		/*User alert = userRepo
				             .findById(userId)
				             .orElseThrow(()-> new CustomException("User", "id", userId,HttpStatus.NOT_FOUND));*/
		
		userRepo.deleteAll();

	    return getAllUsers();
	}
	

}
