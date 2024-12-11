package com.zplus.ZplusBackend.service;



import com.zplus.ZplusBackend.dto.req.GallaryRequestDto;
import com.zplus.ZplusBackend.model.GallaryMaster;

import java.util.List;

public interface GallaryService {

    public Boolean create(GallaryRequestDto gallaryRequestDto);

    public Boolean update(GallaryRequestDto gallaryRequestDto);

    public Boolean delete(Integer gallaryId);

    public GallaryMaster getGallaryById(Integer gallaryId);

    public List getAll();

    public List getAllByStatus();
}
