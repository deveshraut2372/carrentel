package com.zplus.ZplusBackend.service;


import com.zplus.ZplusBackend.dto.req.OurFranchiseRequestDto;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.OurFranchiseMaster;

import java.util.List;

public interface OurFranchiseService {

    public MainResDto create(OurFranchiseRequestDto ourFranchiseRequestDto);

    public MainResDto update(OurFranchiseRequestDto ourFranchiseRequestDto);

    public OurFranchiseMaster findById(Integer ourFranchiseId);

    public List getAll();

    public List getAllByStatus();

    public long getCount();
}
