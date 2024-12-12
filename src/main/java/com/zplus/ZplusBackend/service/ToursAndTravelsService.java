package com.zplus.ZplusBackend.service;

import com.zplus.ZplusBackend.dto.ToursAndTravelsReq;
import com.zplus.ZplusBackend.model.ToursAndTravelsMaster;

import java.util.List;

public interface ToursAndTravelsService {
    Boolean create(ToursAndTravelsReq toursAndTravelsReq);

    Boolean update(ToursAndTravelsReq toursAndTravelsReq);

    ToursAndTravelsMaster getById(Integer toursAndTraveId);

    List getAll();

    List getAllByStatus();
}
