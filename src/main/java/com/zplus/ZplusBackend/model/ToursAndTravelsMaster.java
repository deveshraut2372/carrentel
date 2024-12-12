package com.zplus.ZplusBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ToursAndTravelsMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer toursAndTraveId;

    private String carName;

    private String carImage;

    private String status;

    private Date date;

}
