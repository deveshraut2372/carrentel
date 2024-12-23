package com.zplus.ZplusBackend.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@NoArgsConstructor
@Data
public class ConnectWithUsResDto {

    private Integer connectWithUsId;

    private String fullName;

    private String phoneNumber;

    private String userEmail;

    private String address;

    private String cartype;

    private String status;

    private Date date;

    private Integer carTPermitId;

    public ConnectWithUsResDto(Integer connectWithUsId, String fullName, String phoneNumber, String userEmail, String address, String cartype, String status, Date date, Integer carTPermitId) {
        this.connectWithUsId = connectWithUsId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.userEmail = userEmail;
        this.address = address;
        this.cartype = cartype;
        this.status = status;
        this.date = date;
        this.carTPermitId = carTPermitId;
    }
}
