package com.example.emailsendproject.controller;

import com.example.emailsendproject.dto.MailDto;
import com.example.emailsendproject.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @PostMapping("/mail")
    public String execMail(@RequestBody MailDto mailDto){
        mailService.mailSend(mailDto);
        return "메일 정상적으로 보내줬습니다.";
    }
}
