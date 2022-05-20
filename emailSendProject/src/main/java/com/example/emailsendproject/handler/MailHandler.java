package com.example.emailsendproject.handler;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;

public class MailHandler {
    private JavaMailSender sender;
    private MimeMessage message;
    private MimeMessageHelper msgHelper;

    public MailHandler(JavaMailSender sender) throws MessagingException {
        this.sender = sender;
        message = sender.createMimeMessage();
        msgHelper = new MimeMessageHelper(message, true, "UTF-8");
    }

    // 보내는 사람 이메일
    public void setFrom(String fromAddress) throws MessagingException{
        msgHelper.setFrom(fromAddress);
    }

    // 받는 사람 이메일
    public void setTo(String email) throws MessagingException{
        msgHelper.setTo(email);
    }

    // 제목
    public void setSubject(String subject) throws MessagingException{
        msgHelper.setSubject(subject);
    }

    // 내용
    public void setText(String text, boolean useHtml) throws MessagingException{
        msgHelper.setText(text, useHtml);
    }

    // 첨부 파일
    public void setAttach(String displayFileName, MultipartFile file) throws MessagingException{
        msgHelper.addAttachment(displayFileName, file);
    }

    // 이미지 삽입
    public void setInline(String contentId, MultipartFile file) throws MessagingException, IOException{
        msgHelper.addInline(contentId, new ByteArrayDataSource(file.getBytes(), "image/jpeg"));
    }

    // 발송
    public void send(){
        try {
            sender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
