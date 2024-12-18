package com.zplus.ZplusBackend.service;

import com.zplus.ZplusBackend.dto.req.CarTPermitReq;
import com.zplus.ZplusBackend.dto.res.CarTPermitRes;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.CarTPermitMaster;

import java.util.List;

public interface CarTPermitService {
    MainResDto createCarTPermit(CarTPermitReq carTPermitReq);

    MainResDto updateCarTPermit(CarTPermitReq carTPermitReq);

    List<CarTPermitRes> getAll();

    List<CarTPermitRes> getActiveAll();

    CarTPermitRes getByCarTPermitId(Integer carTPermitId);

    Boolean DeleteByCarTPermitId(Integer carTPermitId);
}
