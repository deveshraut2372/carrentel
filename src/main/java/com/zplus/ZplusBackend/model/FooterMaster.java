package com.zplus.ZplusBackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class FooterMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer footerId;

    private String location;

    private String email;

    private String mobile;

    @Temporal(TemporalType.TIME)
    private Date openTime;

    private String fbLink;

    private String instaLink;

    private String twitterLink;

    private String ytLink;

    private String whatsappLink;

    private String status;

}
