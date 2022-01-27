package com.example.save42lms.persistence;

import com.example.save42lms.model.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, String> {
    List<AttendanceEntity> findByUserId(String userId);
}
