package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.CarTPermitDao;
import com.zplus.ZplusBackend.dao.CarTPointDao;
import com.zplus.ZplusBackend.dto.req.CarTPermitReq;
import com.zplus.ZplusBackend.dto.res.CarTPermitRes;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.CarTPermitMaster;
import com.zplus.ZplusBackend.model.CarTPoint;
import com.zplus.ZplusBackend.service.CarTPermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarTPermitServiceImpl implements CarTPermitService {

    @Autowired
    private CarTPermitDao carTPermitDao;

    @Autowired
    private CarTPointDao cartTPointDao;



    @Override
    public MainResDto createCarTPermit(CarTPermitReq carTPermitReq) {

        MainResDto mainResDto=new MainResDto();

        try {
            CarTPermitMaster carTPermitMaster = new CarTPermitMaster();

            carTPermitMaster.setTitle(carTPermitReq.getTitle());
            carTPermitMaster.setImage(carTPermitReq.getImage());
            carTPermitMaster.setDate(new Date());
            carTPermitMaster.setStatus("Active");

            CarTPermitMaster carTPermitMaster1 = carTPermitDao.save(carTPermitMaster);

            for (String point : carTPermitReq.getCarTPoints()) {
                CarTPoint carTPoint = new CarTPoint();
                carTPoint.setPoint(point);
                carTPoint.setDate(new Date());
                carTPoint.setStatus("Active");
                carTPoint.setCarTPermitMaster(carTPermitMaster1);
                cartTPointDao.save(carTPoint);
            }

            mainResDto.setFlag(true);
            mainResDto.setMessage(" Create Succesfully ");
            mainResDto.setResponseCode(HttpStatus.CREATED.value());
            return mainResDto;
        }catch (Exception e) {
            e.printStackTrace();
            mainResDto.setFlag(false);
            mainResDto.setMessage(" Not Succesfully ");
            mainResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            return mainResDto;
        }
    }


    @Override
    public MainResDto updateCarTPermit(CarTPermitReq carTPermitReq)
    {

        MainResDto mainResDto=new MainResDto();

        try {
            CarTPermitMaster carTPermitMaster =carTPermitDao.findById(carTPermitReq.getCarTPermitId()).get();
            carTPermitMaster.setTitle(carTPermitReq.getTitle());
            carTPermitMaster.setImage(carTPermitReq.getImage());
            carTPermitMaster.setStatus(carTPermitReq.getStatus());
            carTPermitMaster.setDate(new Date());

            CarTPermitMaster carTPermitMaster1 = carTPermitDao.save(carTPermitMaster);

            List<CarTPoint> carTPointList=new ArrayList<>();

            carTPointList=cartTPointDao.getAllByCartPermitId(carTPermitReq.getCarTPermitId());
//            cartTPointDao.deleteAll(carTPointList);

            carTPointList.stream().forEach(carTPoint ->{
                carTPoint.setCarTPermitMaster(null);
                CarTPoint carTPoint1=cartTPointDao.save(carTPoint);
                cartTPointDao.delete(carTPoint1);
            });

            for (String point : carTPermitReq.getCarTPoints()) {
                CarTPoint carTPoint = new CarTPoint();
                carTPoint.setPoint(point);
                carTPoint.setDate(new Date());
                carTPoint.setStatus("Active");
                carTPoint.setCarTPermitMaster(carTPermitMaster1);
                cartTPointDao.save(carTPoint);
            }

            mainResDto.setFlag(true);
            mainResDto.setMessage(" updated Succesfully ");
            mainResDto.setResponseCode(HttpStatus.CREATED.value());
            return mainResDto;
        }catch (Exception e)
        {
            e.printStackTrace();
            mainResDto.setFlag(false);
            mainResDto.setMessage(" Not Updated Succesfully ");
            mainResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            return mainResDto;
        }
    }

    @Override
    public List<CarTPermitRes> getAll()
    {
        List<CarTPermitRes> carTPermitResList=new ArrayList<>();
        List<CarTPermitMaster> carTPermitMasterList=carTPermitDao.findAll();
        carTPermitResList=carTPermitMasterList.stream().parallel().map(carTPermitMaster -> {
            return new CarTPermitRes(carTPermitMaster.getCarTPermitId(),carTPermitMaster.getImage(),carTPermitMaster.getTitle(),carTPermitMaster.getStatus(),carTPermitMaster.getDate(),cartTPointDao.getAllCarTpoints(carTPermitMaster.getCarTPermitId()));
        }).collect(Collectors.toList());
       return  carTPermitResList;
    }

    @Override
    public List<CarTPermitRes> getActiveAll()
    {
        List<CarTPermitRes> carTPermitResList=new ArrayList<>();
        List<CarTPermitMaster> carTPermitMasterList=carTPermitDao.findAllByStatus("Active");
        carTPermitResList=carTPermitMasterList.stream().parallel().map(carTPermitMaster -> {
            return new CarTPermitRes(carTPermitMaster.getCarTPermitId(),carTPermitMaster.getImage(),carTPermitMaster.getTitle(),carTPermitMaster.getStatus(),carTPermitMaster.getDate(),cartTPointDao.getAllCarTpoints(carTPermitMaster.getCarTPermitId()));
        }).collect(Collectors.toList());
        return carTPermitResList;
    }

    @Override
    public CarTPermitRes getByCarTPermitId(Integer carTPermitId) {
        CarTPermitRes carTPermitRes=new CarTPermitRes();
        carTPermitRes=carTPermitDao.getByCarcar(carTPermitId);
        List<String> cartTpoinst=cartTPointDao.getAllCarTpoints(carTPermitId);
        carTPermitRes.setCarTPoints(cartTpoinst);
        return carTPermitRes;
    }

    @Override
    public Boolean DeleteByCarTPermitId(Integer carTPermitId) {
        try
        {
            carTPermitDao.deleteById(carTPermitId);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }


}

