package com.zplus.ZplusBackend.service;



import com.zplus.ZplusBackend.dto.req.AboutUsRequestDto;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.AboutUsMaster;

import java.util.List;

public interface AboutUsService {

    public MainResDto create(AboutUsRequestDto aboutUsRequestDto);

    public Boolean update(AboutUsRequestDto aboutUsRequestDto);

    public Boolean delete(Integer aboutUsId);

    public AboutUsMaster getById(Integer aboutUsId);

    public List getAll();

    public List getAllByStatus();
}
