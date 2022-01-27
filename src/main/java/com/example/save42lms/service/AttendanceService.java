package com.example.save42lms.service;

import com.example.save42lms.model.AttendanceEntity;
import com.example.save42lms.persistence.AttendanceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AttendanceService {
    @Autowired
    private AttendanceRepository repository;

    private void validate(final AttendanceEntity entity){
        if (entity == null){
            log.warn("Entity cannot be null");
            throw new RuntimeException("Entity cannot be null.");
        }

        if (entity.getUserId() == null){
            log.warn("Unknown user.");
            throw new RuntimeException("Unknown user");
        }
    }

    public List<AttendanceEntity> attendanceCreate(final AttendanceEntity attendanceEntity){
        validate(attendanceEntity);
        repository.save(attendanceEntity);
        log.info("Entity id : {} is saved.", attendanceEntity.getId());

        return repository.findByUserId(attendanceEntity.getUserId());
    }

    public List<AttendanceEntity> attendanceRetrieve(final String userId) {return repository.findByUserId(userId);}

    public List<AttendanceEntity> update(final AttendanceEntity entity){
        validate(entity);
        final Optional<AttendanceEntity> original = repository.findById(entity.getId());

        original.ifPresent(attendance -> {
            attendance.setAttendanceSocre(entity.getAttendanceSocre());
            attendance.setAttendanceStatus(entity.getAttendanceStatus());
            attendance.setTotalAttendance(entity.getTotalAttendance());
            attendance.setAojiTime(entity.getAojiTime());
            repository.save(attendance);
        });

        return attendanceRetrieve(entity.getUserId());
    }

    public List<AttendanceEntity> delete(final AttendanceEntity entity){
        validate(entity);

        try{
            repository.delete(entity);
        } catch (Exception e){
            log.error("error deleting entity Attendance");
            throw new RuntimeException("Error deleting entity Attendance " + entity.getId());
        }

        return attendanceRetrieve(entity.getUserId());
    }
}


