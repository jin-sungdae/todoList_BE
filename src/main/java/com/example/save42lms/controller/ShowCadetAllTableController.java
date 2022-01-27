package com.example.save42lms.controller;

import com.example.save42lms.dto.ResponseDto;
import com.example.save42lms.dto.ShowCadetAllTableDto;
import com.example.save42lms.model.ShowCadetAllTableEntity;
import com.example.save42lms.service.ShowCadetAllTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("ShowCadetTableAllTable")
//@CrossOrigin(origins = "http://2save-be.ap-northeast-2.elasticbeanstalk.com")
public class ShowCadetAllTableController {
    @Autowired
    private ShowCadetAllTableService showCadetAllTableService;

    @PostMapping
    public ResponseEntity<?> createShowCadetTable(@RequestBody ShowCadetAllTableDto dto){
        try{
            String temporaryUserId = "temporary-user";
            ShowCadetAllTableEntity entity = ShowCadetAllTableDto.toEntity(dto);
            entity.setId(null);
            entity.setUserId(temporaryUserId);
            List<ShowCadetAllTableEntity> entities = showCadetAllTableService.CadetTableCreate(entity);
            List<ShowCadetAllTableDto> dtos = entities.stream().map(ShowCadetAllTableDto::new).collect(Collectors.toList());
            ResponseDto<ShowCadetAllTableDto> response = ResponseDto.<ShowCadetAllTableDto>builder().data(dtos).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            String error = e.getMessage();
            ResponseDto<ShowCadetAllTableDto> response = ResponseDto.<ShowCadetAllTableDto>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping
    public ResponseEntity<?> retrieveCadetTableList(){
        String temporaryUserId = "temporary-user";
        List<ShowCadetAllTableEntity> entities = this.showCadetAllTableService.CadetTableRetrieve(temporaryUserId);
        List<ShowCadetAllTableDto> dtos = entities.stream().map(ShowCadetAllTableDto::new).collect(Collectors.toList());
        ResponseDto<ShowCadetAllTableDto> response = ResponseDto.<ShowCadetAllTableDto>builder().data(dtos).build();
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    public ResponseEntity<?> updateCadetTableList(@RequestBody ShowCadetAllTableDto dto){
        String temporaryUserId = "temporary-user";
        ShowCadetAllTableEntity entity = ShowCadetAllTableDto.toEntity(dto);
        entity.setUserId(temporaryUserId);
        List<ShowCadetAllTableEntity> entities = this.showCadetAllTableService.CadetTableUpdate(entity);
        List<ShowCadetAllTableDto> dtos = entities.stream().map(ShowCadetAllTableDto::new).collect(Collectors.toList());
        ResponseDto<ShowCadetAllTableDto> response = ResponseDto.<ShowCadetAllTableDto>builder().data(dtos).build();
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCadetTableList(@RequestBody ShowCadetAllTableDto dto){
        try{
            String temporaryUserId = "temporary-user";
            ShowCadetAllTableEntity entity = ShowCadetAllTableDto.toEntity(dto);
            entity.setUserId(temporaryUserId);
            List<ShowCadetAllTableEntity> entities = this.showCadetAllTableService.delete(entity);
            List<ShowCadetAllTableDto> dtos = entities.stream().map(ShowCadetAllTableDto::new).collect(Collectors.toList());
            ResponseDto<ShowCadetAllTableDto> response = ResponseDto.<ShowCadetAllTableDto>builder().data(dtos).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            String error = e.getMessage();
            ResponseDto<ShowCadetAllTableDto> response = ResponseDto.<ShowCadetAllTableDto>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
}
