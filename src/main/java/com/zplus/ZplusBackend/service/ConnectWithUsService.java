package com.zplus.ZplusBackend.service;

import com.zplus.ZplusBackend.dto.req.ConnectWithUsReqDto;
import com.zplus.ZplusBackend.dto.res.ConnectWithUsResDto;
import com.zplus.ZplusBackend.model.ConnectWithUsMaster;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConnectWithUsService {
    List getAll();

    ConnectWithUsResDto getById(Integer connectWithUsId);

    Boolean create(ConnectWithUsReqDto connectWithUsReqDto);

    Boolean update(ConnectWithUsReqDto connectWithUsReqDto);

    List getAllByStatus();

    List<ConnectWithUsResDto> getAllByCarTPermitId(Integer carTPermitId);
}
