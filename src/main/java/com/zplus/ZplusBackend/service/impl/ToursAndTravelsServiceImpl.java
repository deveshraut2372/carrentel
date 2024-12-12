package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.ToursAndTravelsDao;
import com.zplus.ZplusBackend.dto.ToursAndTravelsReq;
import com.zplus.ZplusBackend.model.ToursAndTravelsMaster;
import com.zplus.ZplusBackend.service.ToursAndTravelsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class ToursAndTravelsServiceImpl implements ToursAndTravelsService {

    @Autowired
    private ToursAndTravelsDao toursAndTravelsDao;


    @Override
    public Boolean create(ToursAndTravelsReq toursAndTravelsReq) {
        ToursAndTravelsMaster toursAndTravelsMaster = new ToursAndTravelsMaster();
        try {
            BeanUtils.copyProperties(toursAndTravelsReq,toursAndTravelsMaster);
            toursAndTravelsMaster.setStatus("Active");
            toursAndTravelsMaster.setDate(new Date());
            this.toursAndTravelsDao.save(toursAndTravelsMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(ToursAndTravelsReq toursAndTravelsReq) {
        ToursAndTravelsMaster toursAndTravelsMaster = new ToursAndTravelsMaster();
        try {
            BeanUtils.copyProperties(toursAndTravelsReq,toursAndTravelsMaster);
            toursAndTravelsMaster.setToursAndTraveId(toursAndTravelsReq.getToursAndTraveId());
            this.toursAndTravelsDao.save(toursAndTravelsMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ToursAndTravelsMaster getById(Integer toursAndTraveId) {
        return toursAndTravelsDao.findById(toursAndTraveId).orElse(null);
    }

    @Override
    public List getAll() {
        return toursAndTravelsDao.findAll();
    }

    @Override
    public List getAllByStatus() {
        return toursAndTravelsDao.findAllByStatus("Active");
    }
}
