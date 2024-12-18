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
public class ToursAndTravelsDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer toursAndTraveDetailsId;

    private String pickupLocation;

    private String tripLocation;

    private String fullName;

    private String phoneNumber;

    private String status;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "toursAndTraveId")
    private ToursAndTravelsMaster toursAndTravelsMaster;

    private String trips;


}
