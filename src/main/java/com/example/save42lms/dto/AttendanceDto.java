package com.example.save42lms.dto;

import com.example.save42lms.model.AttendanceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDto {
    private String id;
    private int attendanceStatus;
    private double goalAchievementRate;
    private double totalAttendance;
    private double attendanceSocre;
    private double aojiTime;

    public AttendanceDto(final AttendanceEntity attendanceEntity){
        this.id = attendanceEntity.getId();
        this.attendanceStatus = attendanceEntity.getAttendanceStatus();
        this.goalAchievementRate = attendanceEntity.getGoalAchievementRate();
        this.totalAttendance = attendanceEntity.getTotalAttendance();
        this.attendanceSocre = attendanceEntity.getAttendanceSocre();
        this.aojiTime = attendanceEntity.getAojiTime();
    }

    public static AttendanceEntity attendanceEntity(final AttendanceDto dto){
        return AttendanceEntity.builder()
                .id(dto.getId())
                .attendanceStatus(dto.getAttendanceStatus())
                .goalAchievementRate(dto.getGoalAchievementRate())
                .totalAttendance(dto.getTotalAttendance())
                .attendanceSocre(dto.getAttendanceSocre())
                .aojiTime(dto.getAojiTime())
                .build();
    }
}
