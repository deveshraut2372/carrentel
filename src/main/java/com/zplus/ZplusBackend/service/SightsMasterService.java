package com.zplus.ZplusBackend.service;

import com.zplus.ZplusBackend.dto.req.SightsMasterReq;
import com.zplus.ZplusBackend.model.SightMaster;

import java.util.List;

public interface SightsMasterService {
    Boolean create(SightsMasterReq sightsMasterReq);

    Boolean update(SightsMasterReq sightsMasterReq);

    SightMaster getById(Integer sightId);

    List getAll();

    List getAllByStatus(String status);

    List getAllSightsBylocationId(Integer locationId);
}
