package com.zplus.ZplusBackend.dto.req;

import com.zplus.ZplusBackend.model.CarTPermitMaster;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import java.util.Date;

@Getter
@Setter
public class ConnectWithUsReqDto {

    private Integer connectWithUsId;

    private String fullName;

    private String phoneNumber;

    private String userEmail;

    private String address;

    private String cartype;

    private String status;

    private Date date;

    private Integer carTPermitId;

}
