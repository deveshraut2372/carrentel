package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.OurTeamDao;
import com.zplus.ZplusBackend.dto.req.OurTeamRequestDto;
import com.zplus.ZplusBackend.model.OurTeamMaster;
import com.zplus.ZplusBackend.service.OurTeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OurTeamServiceImpl implements OurTeamService {

    @Autowired
    private OurTeamDao ourTeamDao;
    @Override
    public Boolean create(OurTeamRequestDto ourTeamRequestDto) {
        OurTeamMaster ourTeamMaster = new OurTeamMaster();
        BeanUtils.copyProperties(ourTeamRequestDto,ourTeamMaster);

        try {
            this.ourTeamDao.save(ourTeamMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(OurTeamRequestDto ourTeamRequestDto) {
        OurTeamMaster ourTeamMaster = new OurTeamMaster();
        ourTeamMaster.setTeamId(ourTeamMaster.getTeamId());
        BeanUtils.copyProperties(ourTeamRequestDto,ourTeamMaster);

        try {
            this.ourTeamDao.save(ourTeamMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean delete(Integer teamId) {
        try {
//            this.ourTeamDao.deleteById(teamId);
            OurTeamMaster ourTeamMaster = new OurTeamMaster();
            ourTeamMaster = this.ourTeamDao.findById(teamId).get();
            ourTeamMaster.setStatus("InActive");
            System.out.println("Team deleted successfully");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public OurTeamMaster findById(Integer teamId) {
        OurTeamMaster ourTeamMaster = new OurTeamMaster();
        try {
            Optional<OurTeamMaster> ourTeamMaster1 = this.ourTeamDao.findById(teamId);
            ourTeamMaster1.ifPresent(setting->BeanUtils.copyProperties(setting,ourTeamMaster));
            return ourTeamMaster;
        }catch (Exception e){
            e.printStackTrace();
            return ourTeamMaster;
        }
    }

    @Override
    public List getAllTeam() {
        return this.ourTeamDao.findAll();
    }

    @Override
    public List getAllByStatus() {
        List list = this.ourTeamDao.findAllByStatus("Active");
        return list;
    }
}
