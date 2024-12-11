package com.zplus.ZplusBackend.dto.res;

import lombok.Data;

import java.util.Date;

@Data
public class AdminResponseDto {

    private Integer adminId;

    private String name;

    private String address;

    private String email;

    private String mobile;

    private String password;

    private String status;

    private Integer otp;

    private Date date;
}
