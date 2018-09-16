package com.msointerceptor.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;

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
import com.msointerceptor.model.AlertManager;
import com.msointerceptor.notificationservices.EmailService;
import com.msointerceptor.notificationservices.SmsServiceImpl;
import com.msointerceptor.repository.AlertManagerRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/alerts")
public class AlertManagerController {

	@Autowired
	AlertManagerRepository alertManagerRepo;
	
	@Autowired
	EmailService emailService;
	
	// private SmsServiceImpl smsServiceImpl;

  
	
	/**
	 * GET ALL ALERTS
	 * @return
	 */
	@GetMapping("")
	public List<AlertManager> 
	getAllAlerts() 
	{
	    return alertManagerRepo.findAll();
	}

	
	/**
	 * Add a New Alert
	 * @param alert
	 * @return
	 */
	@PostMapping("/add")
	public AlertManager
	createAlerts( @Valid @RequestBody AlertManager alert)
	{
		System.out.println("AlertTrigger"+alert.getAlertTrigger()+"AlertType"+alert.getAlertType());
			
		
			AlertManager newAlert = alertManagerRepo.saveAndFlush(alert);
			
			if(newAlert.getAlertType().contains("@")) {
				
				emailService.sendSimpleMessage(newAlert.getAlertType(), "Testing mail", "Hi status of the flow");
			}else {
				System.out.println("Mobile sms");
				SmsServiceImpl.sendSimpleSms(newAlert.getAlertType(), "Hi status Message");
				
			}
	     return newAlert;
	    // return  this.getAllAlerts();
	}
	
	/**
	 * Update a Alert
	 * @param alertId
	 * @param alertDetails
	 * @return
	 */
	@PutMapping("/update/{id}")
	public List<AlertManager> 
	updateAlert(@PathVariable(value = "id") int alertId,
	           @Valid @RequestBody AlertManager alertDetails) 
	{
		
		AlertManager alert = alertManagerRepo
							 .findById(alertId)
							  .orElseThrow(()-> new CustomException("AlertManager", "id", alertId,HttpStatus.NOT_FOUND));

	    alert.setAlertTrigger(alertDetails.getAlertTrigger());
	    alert.setAlertType(alertDetails.getAlertType());
	    alertManagerRepo.saveAndFlush(alert);

	    return getAllAlerts();
	}
	
	/**
	 * Get Single alert deatials
	 * @param alertId
	 * @return
	 */
	@GetMapping("get/{id}")
	public AlertManager 
	getAlertById(@PathVariable(value = "id") int alertId)
	{
	    return alertManagerRepo.findById(alertId)
	    		.orElseThrow(()-> new CustomException("AlertManager", "id", alertId,HttpStatus.NOT_FOUND));
	}

	/**
	 * delete alert by Id
	 * @param alertId
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public List<AlertManager> 
	deleteAlert(@PathVariable(value = "id") int alertId) 
	{
		AlertManager alert = alertManagerRepo
				             .findById(alertId)
				             .orElseThrow(()-> new CustomException("AlertManager", "id", alertId,HttpStatus.NOT_FOUND));
		
		alertManagerRepo.delete(alert);

	    return getAllAlerts();
	}
	

}
