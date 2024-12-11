package com.zplus.ZplusBackend.dto.req;

import lombok.Data;

@Data
public class AboutUsRequestDto {

    private Integer aboutUsId;

    private String aboutUsHeading;

    private String icon;

    private Integer count;

    private String status;
}
