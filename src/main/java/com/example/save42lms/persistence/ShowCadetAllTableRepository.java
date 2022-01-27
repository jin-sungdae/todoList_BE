package com.example.save42lms.persistence;

import com.example.save42lms.model.ShowCadetAllTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowCadetAllTableRepository extends JpaRepository<ShowCadetAllTableEntity, String> {
    List<ShowCadetAllTableEntity> findByUserId(String userId);
}
