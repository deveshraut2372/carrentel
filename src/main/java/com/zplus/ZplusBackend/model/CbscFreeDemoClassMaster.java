package com.zplus.ZplusBackend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CbscFreeDemoClassMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cbscFreeDemoId;
    private String name;
    private String whatsappNo;
    private String city;
    private String schoolName;
    private String status;

    @Temporal(TemporalType.DATE)
    private Date date;
}
