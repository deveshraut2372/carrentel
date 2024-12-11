package com.zplus.ZplusBackend.service;


import com.zplus.ZplusBackend.dto.req.FranchiseeEnquiryRequestDto;
import com.zplus.ZplusBackend.model.FranchiseeEnquiryMaster;

import java.util.List;

public interface FranchiseeEnquiryService {

    public Boolean create(FranchiseeEnquiryRequestDto franchiseeEnquiryRequestDto);

    public Boolean update(FranchiseeEnquiryRequestDto franchiseeEnquiryRequestDto);

    public FranchiseeEnquiryMaster getById(Integer franchiseeId);

    public List getAll();

    public List getAllByStatus();

    public Long getCount();
}
