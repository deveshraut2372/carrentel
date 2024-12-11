package com.zplus.ZplusBackend.service;

import com.zplus.ZplusBackend.dto.req.CarMasterReq;
import com.zplus.ZplusBackend.model.CarMaster;

import java.util.List;

public interface CarMasterService {
    Boolean create(CarMasterReq carMasterReq);

    Boolean update(CarMasterReq carMasterReq);

    CarMaster getById(Integer carId);

    List getAll();

    List getAllByStatus();
}
