package com.example.save42lms.dto;

import com.example.save42lms.model.ShowCadetAllTableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowCadetAllTableDto {
    private String id;
    private String userName;
    private double nowStatus;
    private int firstYear;
    private int firstMonth;
    private int firstDay;
    private String role;
    private String progress;
    private short checkIn;
    private short checkOut;

    public ShowCadetAllTableDto(final ShowCadetAllTableEntity entity){
        this.id = entity.getId();
        this.userName = entity.getUserName();
        this.nowStatus = entity.getNowStatus();
        this.firstYear = entity.getFirstYear();
        this.firstMonth = entity.getFirstMonth();
        this.firstDay = entity.getFirstDay();
        this.role = entity.getRole();
        this.progress = entity.getProgress();
        this.checkIn = entity.getCheckIn();
        this.checkOut = entity.getCheckOut();
    }

    public static ShowCadetAllTableEntity toEntity(final ShowCadetAllTableDto dto){
        return ShowCadetAllTableEntity.builder()
                .id(dto.getId())
                .userName(dto.getUserName())
                .nowStatus(dto.getNowStatus())
                .firstYear(dto.getFirstYear())
                .firstMonth(dto.getFirstMonth())
                .firstDay(dto.getFirstDay())
                .role(dto.getRole())
                .progress(dto.getProgress())
                .checkIn(dto.getCheckIn())
                .checkOut(dto.getCheckOut())
                .build();
    }
}
