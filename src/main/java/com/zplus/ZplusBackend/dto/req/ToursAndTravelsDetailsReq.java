package com.zplus.ZplusBackend.dto.req;

import com.zplus.ZplusBackend.model.ToursAndTravelsMaster;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class ToursAndTravelsDetailsReq {

    private Integer toursAndTraveDetailsId;

    private String pickupLocation;

    private String tripLocation;

    private String fullName;

    private String phoneNumber;

    private String status;

    private Date date;

    private Integer toursAndTraveId;
}
