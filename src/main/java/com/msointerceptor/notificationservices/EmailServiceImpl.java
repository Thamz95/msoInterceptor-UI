package com.msointerceptor.notificationservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {
  
    @Autowired
    public JavaMailSender emailSender;
 
    public void sendSimpleMessage(
      String to, String subject, String text) {
        
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
   
    }
    
//    public static final String ACCOUNT_SID = "AC9ad8cf99b7d4fecd72a92184fc16e415"; 
//    public static final String AUTH_TOKEN = "[AuthToken]"; 
// 
//    public static void main(String[] args) { 
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
//        Message message = Message.creator( 
//                new com.twilio.type.PhoneNumber("+919600765275"), 
//                new com.twilio.type.PhoneNumber("+15868003544"),  
//                "Hi")      
//            .create(); 
// 
//        System.out.println(message.getSid()); 
//    }

}
