package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.OurFranchiseDao;
import com.zplus.ZplusBackend.dto.req.OurFranchiseRequestDto;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.OurFranchiseMaster;
import com.zplus.ZplusBackend.service.OurFranchiseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OurFranchiseServiceImpl implements OurFranchiseService {

    @Autowired
    private OurFranchiseDao ourFranchiseDao;

    @Override
    public MainResDto create(OurFranchiseRequestDto ourFranchiseRequestDto) {
        MainResDto mainResDto = new MainResDto();
        try {
            OurFranchiseMaster ourFranchiseMaster = new OurFranchiseMaster();
            BeanUtils.copyProperties(ourFranchiseRequestDto,ourFranchiseMaster);
            this.ourFranchiseDao.save(ourFranchiseMaster);
            mainResDto.setMessage("Our franchise created");
            mainResDto.setFlag(true);
            mainResDto.setResponseCode(HttpStatus.OK.value());
            return mainResDto;
        }catch (Exception e){
            e.printStackTrace();
            mainResDto.setMessage("Our franchise not created");
            mainResDto.setFlag(false);
            mainResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            return mainResDto;
        }
    }

    @Override
    public MainResDto update(OurFranchiseRequestDto ourFranchiseRequestDto) {
        OurFranchiseMaster ourFranchiseMaster = new OurFranchiseMaster();
        MainResDto  mainResDto = new MainResDto();
        try {
            ourFranchiseMaster.setOurFranchiseId(ourFranchiseRequestDto.getOurFranchiseId());
            BeanUtils.copyProperties(ourFranchiseRequestDto,ourFranchiseMaster);
            this.ourFranchiseDao.save(ourFranchiseMaster);
            mainResDto.setMessage("Franchise updated successfully");
            mainResDto.setFlag(true);
            mainResDto.setResponseCode(HttpStatus.OK.value());
            return mainResDto;
        }catch (Exception e){
            e.printStackTrace();
            mainResDto.setMessage("Franchise not created");
            mainResDto.setFlag(false);
            mainResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            return mainResDto;
        }
    }

    @Override
    public OurFranchiseMaster findById(Integer ourFranchiseId) {
        OurFranchiseMaster ourFranchiseMaster = new OurFranchiseMaster();
        try {
            Optional<OurFranchiseMaster> ourFranchiseMaster1 = this.ourFranchiseDao.findById(ourFranchiseId);
            ourFranchiseMaster1.ifPresent(setting->BeanUtils.copyProperties(setting,ourFranchiseMaster));
            return ourFranchiseMaster;
        }catch (Exception e){
            e.printStackTrace();
            return ourFranchiseMaster;
        }
    }

    @Override
    public List getAll() {
        List list = this.ourFranchiseDao.findAll();
        return list;
    }

    @Override
    public List getAllByStatus() {
        List list = this.ourFranchiseDao.getAllByStatus("Active");
        return list;
    }

    @Override
    public long getCount() {
        return this.ourFranchiseDao.count();
    }
}
