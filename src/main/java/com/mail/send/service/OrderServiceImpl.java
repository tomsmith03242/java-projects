package com.mail.send.service;



import java.util.Arrays;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
 
@Service("orderService")
public class OrderServiceImpl implements OrderService {
@Autowired 
JavaMailSender sender;
	@Override
	public String orderdetails(float[] price, String[] items,String[] senderMails) {
		// calculate bill amt
	float total=0.0f;
		for(float p:price) {
			total=total+p;
		}
		String msg="Bill Amout for "+Arrays.deepToString(items)+" is ::"+total+"";
		sendMail(senderMails, msg, "Bill Details");
		return msg;
	}

	private String sendMail(String[] senderMails,String body,String subject) {
		//
		MimeMessage message =sender.createMimeMessage();
		//message.
		//create Message helper
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
		//MimeMessageHelper helper = new MimeMessageHelper(message);
	//set attribute for eamil mesage
		
			helper.setFrom("spring716am@gmail.com");
			helper.setBcc("tomsmith03242@gmail.com");
			helper.setCc(senderMails);
			helper.setSubject(subject);
			helper.setTo(senderMails);			
			helper.setText(body);
			helper.setSentDate(new Date());
			helper.addAttachment("nit.jpg",new ClassPathResource("nit.jpg"));
			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "mail has been delivered to "+Arrays.deepToString(senderMails);
	}
}
