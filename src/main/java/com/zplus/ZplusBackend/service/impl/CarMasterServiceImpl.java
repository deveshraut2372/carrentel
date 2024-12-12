package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.CarMasterDao;
import com.zplus.ZplusBackend.dto.req.CarMasterReq;
import com.zplus.ZplusBackend.model.BannerMaster;
import com.zplus.ZplusBackend.model.CarMaster;
import com.zplus.ZplusBackend.service.CarMasterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CarMasterServiceImpl implements CarMasterService {

    @Autowired
    private CarMasterDao carMasterDao;


    @Override
    public Boolean create(CarMasterReq carMasterReq) {
        CarMaster carMaster = new CarMaster();
        try {
            BeanUtils.copyProperties(carMasterReq,carMaster);
            carMaster.setStatus("Active");
            carMaster.setDate(new Date());
            this.carMasterDao.save(carMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(CarMasterReq carMasterReq) {
        CarMaster carMaster = new CarMaster();
        try {
            BeanUtils.copyProperties(carMasterReq,carMaster);
            carMaster.setDate(new Date());
            carMaster.setCarId(carMasterReq.getCarId());
            this.carMasterDao.save(carMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public CarMaster getById(Integer carId) {
      CarMaster carMaster=new CarMaster();
      carMaster=carMasterDao.findById(carId).orElse(null);
      return carMaster;
    }

    @Override
    public List getAll() {
        return carMasterDao.findAll();
    }

    @Override
    public List getAllByStatus() {
        return carMasterDao.findAllByStatus("Active");
    }
}
