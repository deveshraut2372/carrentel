package com.zplus.ZplusBackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LocationMasterReq {

    private Integer locationId;

    private String locationName;

    private String status;

    private Date date;

}
