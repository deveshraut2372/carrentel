package com.zplus.ZplusBackend.dto.req;

import lombok.Data;

@Data
public class BannerRequestDto {

    private Integer bannerId;

    private String Image;

    private String status;
}
