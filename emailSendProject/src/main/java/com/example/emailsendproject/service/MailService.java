package com.example.emailsendproject.service;

import com.example.emailsendproject.dto.MailDto;
import com.example.emailsendproject.handler.MailHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void mailSend(MailDto mailDto){
        try {
            MailHandler mailHandler = new MailHandler(javaMailSender);
            mailHandler.setTo(mailDto.getAddress());
            mailHandler.setSubject(mailDto.getTitle());
            String htmlContent = "<h1>" + mailDto.getMessage() + "<h1>";
            mailHandler.setText(htmlContent, true);
            //mailHandler.setAttach(mailDto.getFile().getOriginalFilename(), mailDto.getFile());
            mailHandler.setInline("sample-img", mailDto.getFile());
            mailHandler.send();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
