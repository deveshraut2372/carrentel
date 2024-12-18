package com.zplus.ZplusBackend.dto.res;

import lombok.*;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@Getter
@Setter
public class CarTPermitRes
{
    private Integer carTPermitId;

    private String image;

    private String title;

    private String status;

    private Date date;

    private List<String> carTPoints;

    public CarTPermitRes(Integer carTPermitId, String image, String title, String status, Date date) {
        this.carTPermitId = carTPermitId;
        this.image = image;
        this.title = title;
        this.status = status;
        this.date = date;
    }

    public CarTPermitRes() {
    }
}


