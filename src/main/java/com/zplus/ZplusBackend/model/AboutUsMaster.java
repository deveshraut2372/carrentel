package com.zplus.ZplusBackend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class AboutUsMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aboutUsId;

    private String aboutUsHeading;

//    private String aboutUsDescription;

    private Integer count;

    private String status;

    private String icon;
}
