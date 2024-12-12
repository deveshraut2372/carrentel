package com.zplus.ZplusBackend.service.impl;


import com.zplus.ZplusBackend.dao.FooterDao;
import com.zplus.ZplusBackend.dto.req.FooterRequestDto;
import com.zplus.ZplusBackend.model.FooterMaster;
import com.zplus.ZplusBackend.service.FooterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FooterServiceImpl implements FooterService {

    @Autowired
    private FooterDao footerDao;

    @Override
    public Boolean create(FooterRequestDto footerRequestDto) {
        FooterMaster footerMaster = new FooterMaster();
        try{
            BeanUtils.copyProperties(footerRequestDto,footerMaster);
            footerMaster.setOpenTime(new Date());
            this.footerDao.save(footerMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(FooterRequestDto footerRequestDto) {
        FooterMaster footerMaster = new FooterMaster();
        try {
            footerMaster.setFooterId(footerRequestDto.getFooterId());
            BeanUtils.copyProperties(footerRequestDto,footerMaster);
            footerMaster.setFooterId(footerRequestDto.getFooterId());
            this.footerDao.save(footerMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getAll() {
        List list = this.footerDao.findAll();
        return list;
    }

    @Override
    public List getAllByStatus() {
        List list = this.footerDao.getAllByStatus("Active");
        return list;
    }

    @Override
    public FooterMaster getById(Integer footerId) {
        FooterMaster footerMaster = new FooterMaster();
        try{
            Optional<FooterMaster> footerMaster1 = this.footerDao.findById(footerId);
            footerMaster1.ifPresent(setting->BeanUtils.copyProperties(setting,footerMaster));
            return footerMaster;
        }catch (Exception e){
            e.printStackTrace();
            return footerMaster;
        }
    }
}
