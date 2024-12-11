package com.zplus.ZplusBackend.service;


import com.zplus.ZplusBackend.dto.req.FooterRequestDto;
import com.zplus.ZplusBackend.model.FooterMaster;

import java.util.List;

public interface FooterService {
    public Boolean create(FooterRequestDto footerRequestDto);

    public Boolean update(FooterRequestDto footerRequestDto);

    public List getAll();

    public List getAllByStatus();

    public FooterMaster getById(Integer footerId);

}
