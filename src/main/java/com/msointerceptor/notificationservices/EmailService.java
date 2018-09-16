package com.msointerceptor.notificationservices;

public interface EmailService {
	
	 public void sendSimpleMessage(
		      String to, String subject, String text);

}
