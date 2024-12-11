package com.zplus.ZplusBackend.dto.res;

import lombok.Data;

@Data
public class OurTeamResponseDto {

    private Integer teamId;

    private String name;

    private String image;

    private String designation;

    private String status;
}
