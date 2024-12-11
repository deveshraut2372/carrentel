package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.LocationMasterDao;
import com.zplus.ZplusBackend.dao.SightsMasterDao;
import com.zplus.ZplusBackend.dto.req.SightsMasterReq;

import com.zplus.ZplusBackend.model.LocationMaster;
import com.zplus.ZplusBackend.model.SightMaster;
import com.zplus.ZplusBackend.service.SightsMasterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SightsMasterServiceImpl implements SightsMasterService {

    @Autowired
    private SightsMasterDao sightsMasterDao;

    @Autowired
    private LocationMasterDao locationMasterDao;


    @Override
    public Boolean create(SightsMasterReq sightsMasterReq) {
        SightMaster sightsMaster = new SightMaster();
        try {
            BeanUtils.copyProperties(sightsMasterReq,sightsMaster);
            LocationMaster locationMaster=new LocationMaster();
            locationMaster=locationMasterDao.findById(sightsMasterReq.getLocationId()).get();
            sightsMaster.setLocationMaster(locationMaster);
            this.sightsMasterDao.save(sightsMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(SightsMasterReq sightsMasterReq) {
        SightMaster sightsMaster = new SightMaster();
        try {
            BeanUtils.copyProperties(sightsMasterReq,sightsMaster);
            LocationMaster locationMaster=new LocationMaster();
            locationMaster=locationMasterDao.findById(sightsMasterReq.getLocationId()).get();
            sightsMaster.setLocationMaster(locationMaster);
            sightsMaster.setSightId(sightsMasterReq.getSightId());
            this.sightsMasterDao.save(sightsMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public SightMaster getById(Integer sightId) {
        return sightsMasterDao.findById(sightId).get();
    }

    @Override
    public List getAll() {
        return sightsMasterDao.findAll();
    }

    @Override
    public List getAllByStatus(String status) {
        return sightsMasterDao.findAllByStatus(status);
    }

    @Override
    public List getAllSightsBylocationId(Integer locationId) {

        List list=new ArrayList();
        list=sightsMasterDao.findAllByLocationMaster_LocationId(locationId);
        return list;
    }


}
