package com.zplus.ZplusBackend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class WhyChooseUsMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer whyChooseUsId;

    private String youTubeLink;

    private String status;
}
