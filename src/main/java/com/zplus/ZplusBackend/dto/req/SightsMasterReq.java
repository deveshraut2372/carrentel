package com.zplus.ZplusBackend.dto.req;

import com.zplus.ZplusBackend.model.LocationMaster;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
public class SightsMasterReq {

    private Integer sightId;

    private String image;

    private String placeName;

    private Date date;

    private String status;

    private Integer locationId;

}
