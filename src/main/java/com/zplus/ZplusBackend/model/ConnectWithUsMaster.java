package com.zplus.ZplusBackend.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Data
@Table(name="connect_with_us")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConnectWithUsMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer connectWithUsId;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
//    @Email
    private String userEmail;

    @Lob
    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String cartype;

    @Column
    private String status;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private Integer carTPermitId;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "carTPermitId")
//    private CarTPermitMaster carTPermitMaster;


}
