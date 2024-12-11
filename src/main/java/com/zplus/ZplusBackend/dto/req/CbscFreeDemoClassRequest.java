package com.zplus.ZplusBackend.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CbscFreeDemoClassRequest {
    private Integer cbscFreeDemoId;
    private String name;
    private String whatsappNo;
    private String city;
    private String schoolName;
    private String status;
    private Date date;
}
