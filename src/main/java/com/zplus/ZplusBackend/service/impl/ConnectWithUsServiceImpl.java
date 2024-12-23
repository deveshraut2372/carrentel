package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.CarTPermitDao;
import com.zplus.ZplusBackend.dao.ConnectWithUsDao;
import com.zplus.ZplusBackend.dto.req.ConnectWithUsReqDto;
import com.zplus.ZplusBackend.dto.res.ConnectWithUsResDto;
import com.zplus.ZplusBackend.model.BannerMaster;
import com.zplus.ZplusBackend.model.CarTPermitMaster;
import com.zplus.ZplusBackend.model.ConnectWithUsMaster;
import com.zplus.ZplusBackend.service.CarTPermitService;
import com.zplus.ZplusBackend.service.ConnectWithUsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ConnectWithUsServiceImpl implements ConnectWithUsService {

    @Autowired
    private ConnectWithUsDao connectWithUsDao;

    @Autowired
    private CarTPermitService carTPermitService;

    @Autowired
    private CarTPermitDao carTPermitDao;



    @Override
    public Boolean create(ConnectWithUsReqDto connectWithUsReqDto) {
        ConnectWithUsMaster connectWithUsMaster = new ConnectWithUsMaster();
        try {
            BeanUtils.copyProperties(connectWithUsReqDto,connectWithUsMaster);
//             CarTPermitMaster carTPermitMaster=new CarTPermitMaster();
//            carTPermitMaster=carTPermitDao.findById(connectWithUsReqDto.getCarTPermitId()).orElse(null);
//            connectWithUsMaster.setCarTPermitMaster(carTPermitMaster);

            connectWithUsMaster.setCarTPermitId(connectWithUsReqDto.getCarTPermitId());
            connectWithUsMaster.setStatus("Active");
            connectWithUsMaster.setDate(new Date());
            this.connectWithUsDao.save(connectWithUsMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(ConnectWithUsReqDto connectWithUsReqDto) {
        ConnectWithUsMaster connectWithUsMaster = new ConnectWithUsMaster();
        try {
            BeanUtils.copyProperties(connectWithUsReqDto,connectWithUsMaster);
//            CarTPermitMaster carTPermitMaster=new CarTPermitMaster();
//            carTPermitMaster=carTPermitDao.findById(connectWithUsReqDto.getCarTPermitId()).orElse(null);
//            connectWithUsMaster.setCarTPermitMaster(carTPermitMaster);
            connectWithUsMaster.setCarTPermitId(connectWithUsReqDto.getCarTPermitId());
            connectWithUsMaster.setDate(new Date());
            this.connectWithUsDao.save(connectWithUsMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ConnectWithUsResDto> getAllByStatus() {
       List<ConnectWithUsResDto> connectWithUsResDtoList=new ArrayList<>();
        connectWithUsResDtoList=connectWithUsDao.getByStatus("Active");
       return connectWithUsResDtoList;
    }

    @Override
    public List<ConnectWithUsResDto> getAllByCarTPermitId(Integer carTPermitId) {
        List<ConnectWithUsResDto> ConnectWithUsResDto=new ArrayList<>();
        ConnectWithUsResDto=connectWithUsDao.getAllByCarTPermitId(carTPermitId);
        return ConnectWithUsResDto;
    }

    @Override
    public List<ConnectWithUsMaster> getAll() {
        List<ConnectWithUsMaster> connectWithUsMasters=new ArrayList<>();

        connectWithUsMasters=connectWithUsDao.findAll();
        return connectWithUsMasters;
    }

    @Override
    public ConnectWithUsResDto getById(Integer connectWithUsId) {

        ConnectWithUsResDto connectWithUsResDto=new ConnectWithUsResDto();
        connectWithUsResDto=connectWithUsDao.getData(connectWithUsId);
        return connectWithUsResDto;
    }



}
