package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.FranchiseeEnquiryDao;
import com.zplus.ZplusBackend.dto.req.FranchiseeEnquiryRequestDto;
import com.zplus.ZplusBackend.model.FranchiseeEnquiryMaster;
import com.zplus.ZplusBackend.service.FranchiseeEnquiryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FranchiseeEnquiryServiceImpl implements FranchiseeEnquiryService {

    @Autowired
    private FranchiseeEnquiryDao franchiseeEnquiryDao;

    @Override
    public Boolean create(FranchiseeEnquiryRequestDto franchiseeEnquiryRequestDto) {
        FranchiseeEnquiryMaster franchiseeEnquiryMaster = new FranchiseeEnquiryMaster();
        try {
            BeanUtils.copyProperties(franchiseeEnquiryRequestDto,franchiseeEnquiryMaster);
            this.franchiseeEnquiryDao.save(franchiseeEnquiryMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(FranchiseeEnquiryRequestDto franchiseeEnquiryRequestDto) {
        FranchiseeEnquiryMaster franchiseeEnquiryMaster = new FranchiseeEnquiryMaster();
        try{
            franchiseeEnquiryMaster.setFranchiseeId(franchiseeEnquiryRequestDto.getFranchiseeId());
            BeanUtils.copyProperties(franchiseeEnquiryRequestDto,franchiseeEnquiryMaster);
            this.franchiseeEnquiryDao.save(franchiseeEnquiryMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public FranchiseeEnquiryMaster getById(Integer franchiseeId) {
        FranchiseeEnquiryMaster franchiseeEnquiryMaster = new FranchiseeEnquiryMaster();
        try {
            Optional<FranchiseeEnquiryMaster> franchiseeEnquiryMaster1 = this.franchiseeEnquiryDao.findById(franchiseeId);
            franchiseeEnquiryMaster1.ifPresent(setting->BeanUtils.copyProperties(setting,franchiseeEnquiryMaster));
            return franchiseeEnquiryMaster;
        }catch (Exception e){
            e.printStackTrace();
            return franchiseeEnquiryMaster;
        }
    }

    @Override
    public List getAll() {
        List list = this.franchiseeEnquiryDao.findAll();
        return list;
    }

    @Override
    public List getAllByStatus() {
            List list = this.franchiseeEnquiryDao.getAllByStatus("Active");
            return list;
    }

    @Override
    public Long getCount() {
        return this.franchiseeEnquiryDao.count();
    }
}
