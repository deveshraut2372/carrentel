package com.zplus.ZplusBackend.dto.req;

import lombok.Data;

@Data
public class AdminLoginRequestDto {

    private String username;

    private String password;
}