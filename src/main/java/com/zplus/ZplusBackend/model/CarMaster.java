package com.zplus.ZplusBackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class CarMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer carId;

    private String carName;

    private String carImage;

    private String carHours;

    private String carprice;

    private  String km;

    private String extraKm;

    private String extraHr;

    private String transmission;

    private String status;

    private Date date;





}
