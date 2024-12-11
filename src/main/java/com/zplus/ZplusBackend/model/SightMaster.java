package com.zplus.ZplusBackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class SightMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sightId;

    private String image;

    private String placeName;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "locationId")
    private LocationMaster locationMaster;


}
