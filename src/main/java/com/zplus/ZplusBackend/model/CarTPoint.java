package com.zplus.ZplusBackend.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
public class CarTPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer carTPointId;

    @Lob
    private String point;

    private String status;

    @Temporal(TemporalType.DATE)
    private Date date;

//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "carTPoint")
//    private CarTPermitMaster carTPermitMaster;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn( name = "fk_carTPermit")
    private CarTPermitMaster carTPermitMaster;


}
