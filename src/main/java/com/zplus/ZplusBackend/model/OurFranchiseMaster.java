package com.zplus.ZplusBackend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class OurFranchiseMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ourFranchiseId;

    private String cityName;

    private String areaName;

    private String status;
}
