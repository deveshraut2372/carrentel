package com.zplus.ZplusBackend.service;


import com.zplus.ZplusBackend.dto.req.WhyChooseUsRequestDto;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.WhyChooseUsMaster;

import java.util.List;

public interface WhyChooseUsService {

    public MainResDto create(WhyChooseUsRequestDto whyChooseUsRequestDto);

    public MainResDto update(WhyChooseUsRequestDto whyChooseUsRequestDto);

    public WhyChooseUsMaster findById(Integer whyChooseUsId);

    public List getAll();

    public List getAllActive();
}
