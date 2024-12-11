package com.zplus.ZplusBackend.dto.req;

import lombok.Data;

@Data
public class OurTeamRequestDto {

    private Integer teamId;

    private String name;

    private String image;

    private String designation;

    private String status;
}
