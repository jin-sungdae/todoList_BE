package com.example.save42lms.dto;

import com.example.save42lms.model.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDto {
    private String id;
    private String title;
    private boolean todoCheck;  //userId 가 없는 이유는 스프링 시큐리티를 이용해 인증을 하기 위해

    public TodoDto(final TodoEntity entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.todoCheck = entity.isTodoCheck();
    }

    public static TodoEntity toEntity(final TodoDto dto){
        return TodoEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .todoCheck(dto.isTodoCheck())
                .build();
    }
}
