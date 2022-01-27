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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="ShowCadetAllTable")
public class ShowCadetAllTableEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String userId;
    private String userName;
    private double nowStatus;
    private int firstYear;
    private int firstMonth;
    private int firstDay;
    private String role;
    private String progress;
    private short checkIn;
    private short checkOut;
}
