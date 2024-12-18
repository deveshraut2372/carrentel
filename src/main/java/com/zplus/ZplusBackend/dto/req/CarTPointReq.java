package com.zplus.ZplusBackend.dto.req;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
public class CarTPointReq {

    private Integer carTPointId;

    private String point;

    private String status;

    private Date date;


}
