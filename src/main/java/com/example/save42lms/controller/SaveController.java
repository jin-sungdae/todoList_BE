package com.example.save42lms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://2save-be.ap-northeast-2.elasticbeanstalk.com")
public class SaveController {
    @GetMapping("/")
    public String SaveCheck(){
        return "안녕하세요 구해줘 카뎃입니다. cors3 ㅠ";
    }
}
