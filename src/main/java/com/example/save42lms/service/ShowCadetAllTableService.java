package com.example.save42lms.service;

import com.example.save42lms.model.ShowCadetAllTableEntity;
import com.example.save42lms.persistence.ShowCadetAllTableRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ShowCadetAllTableService {
    @Autowired
    private ShowCadetAllTableRepository repository;

    private void validate(final ShowCadetAllTableEntity entity){
        if (entity == null){
            log.warn("Entity cannot be null");
            throw new RuntimeException("Entity cannot be null.");
        }

        if (entity.getUserId() == null){
            log.warn("Unknown user.");
            throw new RuntimeException("Unknown user");
        }
    }

    public List<ShowCadetAllTableEntity> CadetTableCreate(final ShowCadetAllTableEntity showCadetAllTableEntity){
        validate(showCadetAllTableEntity);
        repository.save(showCadetAllTableEntity);
        log.info("Entity id : {} is saved.", showCadetAllTableEntity.getId());
        return repository.findByUserId(showCadetAllTableEntity.getUserId());
    }

    public List<ShowCadetAllTableEntity> CadetTableRetrieve(final String userId){
        return repository.findByUserId(userId);
    }

    public List<ShowCadetAllTableEntity> CadetTableUpdate(final ShowCadetAllTableEntity entity){
        validate(entity);
        final Optional<ShowCadetAllTableEntity> original = repository.findById(entity.getId());

        original.ifPresent(cadetTable -> {
            cadetTable.setUserName(entity.getUserName());
            cadetTable.setNowStatus(entity.getNowStatus());
            cadetTable.setFirstYear(entity.getFirstYear());
            cadetTable.setFirstMonth(entity.getFirstMonth());
            cadetTable.setFirstDay(entity.getFirstDay());
            cadetTable.setRole(entity.getRole());
            cadetTable.setProgress(entity.getProgress());
            cadetTable.setCheckIn(entity.getCheckIn());
            cadetTable.setCheckOut(entity.getCheckOut());
            this.repository.save(cadetTable);
        });
        return CadetTableRetrieve(entity.getUserId());
    }

    public List<ShowCadetAllTableEntity> delete(final ShowCadetAllTableEntity entity){
        validate(entity);

        try{
            repository.delete(entity);
        } catch (Exception e){
            log.error("error delete entity ShowCadetTable");
            throw new RuntimeException("Error deleting entity Attendance" + entity.getId());
        }
        return CadetTableRetrieve(entity.getUserId());
    }
}
