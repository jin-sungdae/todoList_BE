package com.example.save42lms.controller;

import com.example.save42lms.dto.AttendanceDto;
import com.example.save42lms.dto.ResponseDto;
import com.example.save42lms.model.AttendanceEntity;
import com.example.save42lms.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("attendence")
//@CrossOrigin(origins = "http://2save-be.ap-northeast-2.elasticbeanstalk.com")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    public ResponseEntity<?> createAttendance(@RequestBody AttendanceDto dto){
        try{
            String temporaryUserId = "temporary-User";
            AttendanceEntity entity = AttendanceDto.attendanceEntity(dto);
            entity.setId(null);
            entity.setUserId(temporaryUserId);
            List<AttendanceEntity> entities = attendanceService.attendanceCreate(entity);
            List<AttendanceDto> dtos = entities.stream().map(AttendanceDto::new).collect(Collectors.toList());
            ResponseDto<AttendanceDto> response = ResponseDto.<AttendanceDto>builder().data(dtos).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            String error = e.getMessage();
            ResponseDto<AttendanceDto> response = ResponseDto.<AttendanceDto>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping
    public ResponseEntity<?> retrieveAttendanceList(){
        String temporaryUserId = "temporary-user";
        List<AttendanceEntity> entities = attendanceService.attendanceRetrieve(temporaryUserId);
        List<AttendanceDto> dtos = entities.stream().map(AttendanceDto::new).collect(Collectors.toList());
        ResponseDto<AttendanceDto> response = ResponseDto.<AttendanceDto>builder().data(dtos).build();
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    public ResponseEntity<?> updateAttendance(@RequestBody AttendanceDto dto){
        String temporaryUserId = "temporary-user";
        AttendanceEntity entity = AttendanceDto.attendanceEntity(dto);
        entity.setUserId(temporaryUserId);
        List<AttendanceEntity> entities = attendanceService.update(entity);
        List<AttendanceDto> dtos = entities.stream().map(AttendanceDto::new).collect(Collectors.toList());
        ResponseDto<AttendanceDto> response = ResponseDto.<AttendanceDto>builder().data(dtos).build();
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping
    private ResponseEntity<?> deleteDto(@RequestBody AttendanceDto dto){
        try{
            String temporaryUserId = "temporary-user";
            AttendanceEntity entity = AttendanceDto.attendanceEntity(dto);
            entity.setUserId(temporaryUserId);
            List<AttendanceEntity> entities = attendanceService.delete(entity);
            List<AttendanceDto> dtos = entities.stream().map(AttendanceDto::new).collect(Collectors.toList());
            ResponseDto<AttendanceDto> response = ResponseDto.<AttendanceDto>builder().data(dtos).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            String error = e.getMessage();
            ResponseDto<AttendanceDto> response = ResponseDto.<AttendanceDto>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
}
