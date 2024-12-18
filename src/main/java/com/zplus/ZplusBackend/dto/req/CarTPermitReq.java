package com.zplus.ZplusBackend.dto.req;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CarTPermitReq {

    private Integer carTPermitId;

    private String image;

    private String title;

    private String status;

    private Date date;

    private List<String> CarTPoints;

}
