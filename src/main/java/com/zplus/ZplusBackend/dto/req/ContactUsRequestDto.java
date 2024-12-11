package com.zplus.ZplusBackend.dto.req;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Getter
@Setter
public class ContactUsRequestDto {

    private Integer contactId;

    private String name;

    private String contactNo;

    private String City;

    private String  tripLocation;

    private String  carModel;

    private String status;

    private Date date;
}
