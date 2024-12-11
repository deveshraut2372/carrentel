package com.zplus.ZplusBackend.service;

import com.zplus.ZplusBackend.dto.LocationMasterReq;
import com.zplus.ZplusBackend.model.LocationMaster;

import java.util.List;

public interface LocationService {
    Boolean create(LocationMasterReq locationMasterReq);

    Boolean update(LocationMasterReq locationMasterReq);

    LocationMaster getById(Integer locationId);

    List getAll();

    List getAllByStatus(String status);
}
