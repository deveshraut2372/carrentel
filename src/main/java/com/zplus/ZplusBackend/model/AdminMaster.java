package com.zplus.ZplusBackend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class AdminMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
