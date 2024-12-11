package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.WhyChooseUsDao;
import com.zplus.ZplusBackend.dto.req.WhyChooseUsRequestDto;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.WhyChooseUsMaster;
import com.zplus.ZplusBackend.service.WhyChooseUsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WhyChooseUsServiceImpl implements WhyChooseUsService {

    @Autowired
    private WhyChooseUsDao whyChooseUsDao;

    @Override
    public MainResDto create(WhyChooseUsRequestDto whyChooseUsRequestDto) {
        MainResDto mainResDto = new MainResDto();
        try {
            WhyChooseUsMaster whyChooseUsMaster = new WhyChooseUsMaster();
            BeanUtils.copyProperties(whyChooseUsRequestDto,whyChooseUsMaster);
            this.whyChooseUsDao.save(whyChooseUsMaster);
            mainResDto.setMessage("Why choose us created successfully");
            mainResDto.setFlag(true);
            mainResDto.setResponseCode(HttpStatus.OK.value());
            return mainResDto;
        }catch (Exception e){
            e.printStackTrace();
            mainResDto.setMessage("Why choose us didn't created");
            mainResDto.setFlag(false);
            mainResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            return mainResDto;
        }
    }

    @Override
    public MainResDto update(WhyChooseUsRequestDto whyChooseUsRequestDto) {
        WhyChooseUsMaster whyChooseUsMaster = new WhyChooseUsMaster();
        MainResDto mainResDto = new MainResDto();

        try {
            whyChooseUsMaster.setWhyChooseUsId(whyChooseUsRequestDto.getWhyChooseUsId());
            BeanUtils.copyProperties(whyChooseUsRequestDto,whyChooseUsMaster);
            this.whyChooseUsDao.save(whyChooseUsMaster);
            mainResDto.setMessage("Why choose us updated successfully");
            mainResDto.setFlag(true);
            mainResDto.setResponseCode(HttpStatus.OK.value());
            return mainResDto;
        }catch (Exception e){
            e.printStackTrace();
            mainResDto.setMessage("Why choose us didn't created");
            mainResDto.setFlag(false);
            mainResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            return mainResDto;
        }

    }

    @Override
    public WhyChooseUsMaster findById(Integer whyChooseUsId) {
        WhyChooseUsMaster whyChooseUsMaster = new WhyChooseUsMaster();
        try {
            Optional<WhyChooseUsMaster> whyChooseUsMaster1 = this.whyChooseUsDao.findById(whyChooseUsId);
            whyChooseUsMaster1.ifPresent(settting->BeanUtils.copyProperties(settting,whyChooseUsMaster));
            return whyChooseUsMaster;
        }catch (Exception e){
            e.printStackTrace();
            return whyChooseUsMaster;
        }
    }

    @Override
    public List getAll() {
        List list = this.whyChooseUsDao.findAll();
        return list;
    }

    @Override
    public List getAllActive() {
        List list = this.whyChooseUsDao.findAllByStatus("Active");
        return list;
    }
}
