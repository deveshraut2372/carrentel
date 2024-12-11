package com.zplus.ZplusBackend.dto.req;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CarMasterReq {

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
