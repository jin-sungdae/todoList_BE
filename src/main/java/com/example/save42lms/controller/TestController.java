package com.example.save42lms.controller;

import com.example.save42lms.dto.ResponseDto;
import com.example.save42lms.dto.TestRequestBodyDto;
import com.example.save42lms.dto.TodoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test") //리소스
public class TestController {
    @GetMapping
    public String testController(){
        return "Hello world!";
    }

    @GetMapping("/testGetMapping")
    public String tesGetMapping(){
        return "hello world! testGetMapping";
    }

    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required = false) int id){
        return "Hello world! ID " + id;
    }

    @GetMapping("/testRequestParam")
    public String testControllerRequestParam(@RequestParam(required = false) int id){
        return "Hello world! ID " + id;
    }

    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDto testRequestBodyDto){
        return "Hello world! ID " + testRequestBodyDto.getId() + "Message : " + testRequestBodyDto.getMessage();
    }

    @GetMapping("/TodoDto")
    public String testTodoDto(@RequestBody TodoDto todoDto){
        return todoDto.toString();
    }

    @GetMapping("/testResponseBody")
    public ResponseDto<String> testControllerResponseBody(){
        List<String> list = new ArrayList<>();
        list.add("hello world! i'm responseDto");
        ResponseDto<String> response = ResponseDto.<String>builder().data(list).build();
        return response;
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity(){
        List<String> list = new ArrayList<>();
        list.add("Hello world! I'm ResponseEntity. And you got 400!");
        ResponseDto<String> response = ResponseDto.<String>builder().data(list).build();
        return ResponseEntity.ok().body(response);
    }
}
