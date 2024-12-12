package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.LocationMasterDao;
import com.zplus.ZplusBackend.dto.LocationMasterReq;
import com.zplus.ZplusBackend.model.BannerMaster;
import com.zplus.ZplusBackend.model.LocationMaster;
import com.zplus.ZplusBackend.service.LocationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationMasterDao locationMasterDao;


    @Override
    public Boolean create(LocationMasterReq locationMasterReq) {
        LocationMaster locationMaster = new LocationMaster();
        try {
//            bannerMaster.setBannerId(bannerRequestDto.getBannerId());
            BeanUtils.copyProperties(locationMasterReq,locationMaster);
            locationMaster.setStatus("Active");
            locationMaster.setDate(new Date());
            this.locationMasterDao.save(locationMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(LocationMasterReq locationMasterReq) {
        LocationMaster locationMaster = new LocationMaster();
        try {
            BeanUtils.copyProperties(locationMasterReq,locationMaster);
            locationMaster.setLocationId(locationMasterReq.getLocationId());
            locationMaster.setDate(new Date());
            this.locationMasterDao.save(locationMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public LocationMaster getById(Integer locationId) {
        return locationMasterDao.findById(locationId).orElse(null);
    }

    @Override
    public List getAll() {
        return locationMasterDao.findAll();
    }

    @Override
    public List getAllByStatus(String status) {
        return locationMasterDao.findAllByStatus(status);
    }

}
