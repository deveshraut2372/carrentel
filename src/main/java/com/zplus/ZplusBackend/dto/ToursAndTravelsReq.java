package com.zplus.ZplusBackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ToursAndTravelsReq {

    private Integer toursAndTraveId;

    private String carName;

    private String carImage;

    private String status;

    private Date date;

}
