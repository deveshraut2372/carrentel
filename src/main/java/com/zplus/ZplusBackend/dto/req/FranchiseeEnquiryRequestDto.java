package com.zplus.ZplusBackend.dto.req;

import lombok.Data;

@Data
public class FranchiseeEnquiryRequestDto {

    private Integer franchiseeId;

    private String fullName;

    private String mobile;

    private String state;

    private String city;

    private String email;

    private String franchiseeLocation;

    private String investmentLevel;

    private String whenTo;

    private String status;
}
