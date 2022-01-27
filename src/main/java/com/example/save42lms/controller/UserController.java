package com.example.save42lms.controller;

import com.example.save42lms.dto.ResponseDto;
import com.example.save42lms.dto.UserDto;
import com.example.save42lms.model.UserEntity;
import com.example.save42lms.security.TokenProvider;
import com.example.save42lms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDto dto){
        try{
            //요청을 이용해 저장할 사용자 만들기
            UserEntity user = UserEntity.builder()
                    .email(dto.getEmail())
                    .username(dto.getUsername())
                    .password(dto.getPassword())
                    .build();

            //서비스를 이용해 리포지터리에 사용자 저장
            UserEntity registerUser = userService.create(user);
            UserDto responseUserDto = UserDto.builder()
                    .email(registerUser.getEmail())
                    .id(registerUser.getId())
                    .username(registerUser.getUsername())
                    .build();
            return ResponseEntity.ok().body(responseUserDto);
        } catch (Exception e){
            // 사용자 정보는 항상 하나이므로 리스트로 만들어야 하는 ResponseDto를 사용하지 않고
            // 그냥 UserDto 리턴
            ResponseDto responseDto = ResponseDto.builder().error(e.getMessage()).build();
            return ResponseEntity
                    .badRequest()
                    .body(responseDto);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody UserDto dto){
        UserEntity user = userService.getByCredentials(
                dto.getEmail(),
                dto.getPassword()
        );

        if (user != null){
            final String token = tokenProvider.create(user);
            final UserDto responseUserDto = UserDto.builder()
                    .email(user.getUsername())
                    .id(user.getId())
                    .token(token)
                    .build();
            return  ResponseEntity.ok().body(responseUserDto);
        } else {
            ResponseDto responseDto = ResponseDto.builder()
                    .error("Login faild")
                    .build();
            return ResponseEntity
                    .badRequest()
                    .body(responseDto);
        }
    }
}
