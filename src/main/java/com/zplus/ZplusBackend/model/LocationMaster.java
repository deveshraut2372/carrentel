package com.zplus.ZplusBackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class LocationMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer locationId;

    private String locationName;

    private String status;

    @Temporal(TemporalType.DATE)
    private Date date;

}
