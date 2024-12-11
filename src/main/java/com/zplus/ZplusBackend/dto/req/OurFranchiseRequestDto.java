package com.zplus.ZplusBackend.dto.req;

import lombok.Data;

@Data
public class OurFranchiseRequestDto {
    private Integer ourFranchiseId;

    private String cityName;

    private String areaName;

    private String status;
}
