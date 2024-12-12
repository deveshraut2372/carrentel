package com.zplus.ZplusBackend.service;

import com.zplus.ZplusBackend.dto.req.ToursAndTravelsDetailsReq;
import com.zplus.ZplusBackend.model.ToursAndTravelsDetails;

import java.util.List;

public interface ToursAndTravelsDetailsService {
    Boolean create(ToursAndTravelsDetailsReq toursAndTravelsDetailsReq);

    Boolean update(ToursAndTravelsDetailsReq toursAndTravelsReq);

    List getAll();

    List getAllByStatus();

    ToursAndTravelsDetails getById(Integer toursAndTraveDetailsId);

    List<ToursAndTravelsDetails> getByToursAndTraveId(Integer toursAndTraveId);
}
