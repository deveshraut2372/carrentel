package com.zplus.ZplusBackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class CarTPermitMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer carTPermitId;

    private String image;

    private String title;

    private String status;

    private Date date;

//    @ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(name = "carTPointId")
//    private CarTPoint carTPoint;


    @OneToMany(mappedBy = "carTPermitMaster",cascade = CascadeType.ALL)
    private List<CarTPoint> carTPointList;

    public CarTPermitMaster(Integer carTPermitId, String image, String title, String status, Date date) {
        this.carTPermitId = carTPermitId;
        this.image = image;
        this.title = title;
        this.status = status;
        this.date = date;
    }

    public CarTPermitMaster() {
    }

}
