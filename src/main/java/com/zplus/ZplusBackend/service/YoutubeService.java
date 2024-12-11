package com.zplus.ZplusBackend.service;

import com.zplus.ZplusBackend.dto.req.YoutubeMasterReq;
import com.zplus.ZplusBackend.model.BannerMaster;
import com.zplus.ZplusBackend.model.YoutubeMaster;

import java.util.List;

public interface YoutubeService {


    Boolean create(YoutubeMasterReq youtubeMasterReq);

    Boolean update(YoutubeMasterReq youtubeMasterReq);

    YoutubeMaster getById(Integer youtubeId);

    List getAll();

    List getAllByStatus(String status);
}
