package com.msointerceptor.notificationservices;

import org.springframework.stereotype.Component;

public class SmsServiceImpl {
	
	
	public static final String ACCOUNT_SID = "AC9ad8cf99b7d4fecd72a92184fc16e415"; 
    public static final String AUTH_TOKEN = "c772e03a7a0496feff4b947f17a46403"; 
    


    public static int sendSimpleSms(String toMobile, String messageContent ) {
    	
        /*Twilio.init("ACCOUNT_SID","AUTH_TOKEN");
        if((!"".equals(toMobile)) 
        		&& (!"".equals(messageContent)))
        {
        	 Message.creator( 
                     new com.twilio.type.PhoneNumber("+919551086186"), 
                   //  new com.twilio.type.PhoneNumber("+15868003544"),  
                     "MGa7352693b6b5893b1139707a7cc2efdd",
                    // new com.twilio.type.PhoneNumber(""), 
                     "Phantom Menace was clearly the best of the prequel trilogy.").create();
        	 
        	 return 1;
        }else {
        	return 0;
        }*/
        
        
      return 0;
    	
    }

}
