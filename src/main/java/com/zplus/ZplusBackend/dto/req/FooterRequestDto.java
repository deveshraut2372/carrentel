package com.zplus.ZplusBackend.dto.req;

import lombok.Data;

import java.util.Date;

@Data
public class FooterRequestDto {

    private Integer footerId;

    private String location;

    private String email;

    private String mobile;

    private Date openTime;

    private String fbLink;

    private String instaLink;

    private String twitterLink;

    private String ytLink;

    private String whatsappLink;

    private String status;
}
