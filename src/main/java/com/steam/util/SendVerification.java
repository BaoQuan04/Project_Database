package com.steam.util;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeUtility;

import java.util.Properties;

public class SendVerification {
    final String username = "n23dccn171@student.ptithcm.edu.vn";
    final String password = "jgnp bdjz vfaq iooa";

    private String from = "35plus-Studio";
//    private String cc = "";
    private String subject = "Confirm Verification Code ";


    public boolean sendVerificationCode(String toEmail, String code){
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username, password);
            }
        });

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username, from, "UTF8"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );
//            message.setRecipients(
//                    Message.RecipientType.CC,
//                    InternetAddress.parse(cc)
//            );

            message.setSubject(MimeUtility.encodeText(subject, "utf-8", "B"));

            String content = "This is your Verification Code, please commit the code in limit time ! " + code;
            message.setContent(content, "text/plain;charset=UTF-8");

            Transport.send(message);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }




}
