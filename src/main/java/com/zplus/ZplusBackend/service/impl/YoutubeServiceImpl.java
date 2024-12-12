package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.YoutubeServiceDao;
import com.zplus.ZplusBackend.dto.req.YoutubeMasterReq;
import com.zplus.ZplusBackend.model.BannerMaster;
import com.zplus.ZplusBackend.model.YoutubeMaster;
import com.zplus.ZplusBackend.service.YoutubeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class YoutubeServiceImpl implements YoutubeService {


    @Autowired
    private YoutubeServiceDao youtubeServiceDao;


    @Override
    public Boolean create(YoutubeMasterReq youtubeMasterReq) {
        YoutubeMaster youtubeMaster = new YoutubeMaster();
        try {
//            youtubeMasterReq.setYoutubeId(bannerRequestDto.getBannerId());
            BeanUtils.copyProperties(youtubeMasterReq,youtubeMaster);
            this.youtubeServiceDao.save(youtubeMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(YoutubeMasterReq youtubeMasterReq) {
        YoutubeMaster youtubeMaster = new YoutubeMaster();
        try {
            BeanUtils.copyProperties(youtubeMasterReq,youtubeMaster);
            youtubeMaster.setYoutubeId(youtubeMasterReq.getYoutubeId());
            this.youtubeServiceDao.save(youtubeMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public YoutubeMaster getById(Integer youtubeId) {
        return youtubeServiceDao.findById(youtubeId).orElse(null);
    }

    @Override
    public List getAll() {
        return youtubeServiceDao.findAll();
    }

    @Override
    public List getAllByStatus(String status) {
        return youtubeServiceDao.findAllByStatus(status);
    }
}
