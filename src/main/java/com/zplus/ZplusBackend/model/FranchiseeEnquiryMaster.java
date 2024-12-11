package com.zplus.ZplusBackend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class FranchiseeEnquiryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
