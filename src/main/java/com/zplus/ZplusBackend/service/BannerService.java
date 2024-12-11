package com.zplus.ZplusBackend.service;



import com.zplus.ZplusBackend.dto.req.BannerRequestDto;
import com.zplus.ZplusBackend.model.BannerMaster;

import java.util.List;

public interface BannerService {

    public Boolean create(BannerRequestDto bannerRequestDto);

    public Boolean update(BannerRequestDto bannerRequestDto);

    public BannerMaster getById(Integer bannerId);

    public List getAll();

    public List getAllByStatus();
}
