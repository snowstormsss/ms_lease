package com.snowstorms.ms_lease_core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailUtil {
	@Autowired
	private static JavaMailSender javaMailSender;
	
	public static void SendMail(SimpleMailMessage message) {
		message.setFrom("2488837660@qq.com");
		//传过来的message对象要设置的内容
		//message.setSentDate("发送日期");
		//message.setSubject("邮箱主题");;
		//message.setTo("接收者邮箱地址");
		//message.setText("主内容");
		javaMailSender.send(message);
	}
}
