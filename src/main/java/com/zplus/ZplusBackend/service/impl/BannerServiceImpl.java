package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.BannerDao;
import com.zplus.ZplusBackend.dto.req.BannerRequestDto;
import com.zplus.ZplusBackend.model.BannerMaster;
import com.zplus.ZplusBackend.service.BannerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Override
    public Boolean create(BannerRequestDto bannerRequestDto) {
        BannerMaster bannerMaster = new BannerMaster();
        try {
            bannerMaster.setBannerId(bannerRequestDto.getBannerId());
            BeanUtils.copyProperties(bannerRequestDto,bannerMaster);
            this.bannerDao.save(bannerMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(BannerRequestDto bannerRequestDto) {
        BannerMaster bannerMaster = new BannerMaster();
        try {
            bannerMaster.setBannerId(bannerRequestDto.getBannerId());
            BeanUtils.copyProperties(bannerRequestDto,bannerMaster);
            this.bannerDao.save(bannerMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public BannerMaster getById(Integer bannerId) {
        BannerMaster bannerMaster = new BannerMaster();

        try {
            Optional<BannerMaster> bannerMaster1 = this.bannerDao.findById(bannerId);
            bannerMaster1.ifPresent(setting->BeanUtils.copyProperties(setting,bannerMaster));
            return bannerMaster;
        }catch (Exception e){
            e.printStackTrace();
            return bannerMaster;
        }
    }

    @Override
    public List getAll() {
        List list = this.bannerDao.findAll();
        return list;
    }

    @Override
    public List getAllByStatus() {
        List list = this.bannerDao.getAllByStatus("Active");
        return list;
    }
}
