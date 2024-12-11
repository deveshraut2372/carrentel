package com.zplus.ZplusBackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ContactUsMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contactId;
    @Column
    private String name;
    @Column
    private String contactNo;

    @Column
    private String City;

    @Column
    private String  tripLocation;

    @Column
    private String  carModel;

    @Column
    private String status;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

}
