package com.example.save42lms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Todo")
public class TodoEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;  // 이 오브젝트의 아이디
    private String userId;  // 이 오브젝트를 생성한 사용자 아이디
    private String title; //Todo 타이틀 예) 운동하기
    private boolean todoCheck; // todo check false - true

}
