package com.zplus.ZplusBackend.dto.req;

import lombok.Data;

@Data
public class GallaryRequestDto {

    private Integer gallaryId;

    private String type;

    private String image;

    private String status;
}
