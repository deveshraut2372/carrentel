package com.zplus.ZplusBackend.dto.req;

import lombok.Data;

@Data
public class MenuRequestDto {

    private Integer menuId;

    private String dishName;

    private Integer price;

    private String image;

    private String status;
}
