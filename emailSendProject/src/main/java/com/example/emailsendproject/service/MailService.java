package com.example.emailsendproject.service;

import com.example.emailsendproject.dto.MailDto;
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
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDto.getAddress()); //보내는 사람 주소
        message.setSubject(mailDto.getTitle()); // 제목
        message.setText(mailDto.getMessage()); // 내용
        javaMailSender.send(message); //메일 발송
    }
}
