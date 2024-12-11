package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.GallaryDao;
import com.zplus.ZplusBackend.dto.req.GallaryRequestDto;
import com.zplus.ZplusBackend.model.GallaryMaster;
import com.zplus.ZplusBackend.service.GallaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GallaryServiceImpl implements GallaryService {

    @Autowired
    private GallaryDao gallaryDao;

    @Override
    public Boolean create(GallaryRequestDto gallaryRequestDto) {
        System.out.println(gallaryRequestDto.toString());
        GallaryMaster gallaryMaster = new GallaryMaster();
        BeanUtils.copyProperties(gallaryRequestDto,gallaryMaster);
        try {
            this.gallaryDao.save(gallaryMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(GallaryRequestDto gallaryRequestDto) {
        GallaryMaster gallaryMaster = new GallaryMaster();
        gallaryMaster.setGallaryId(gallaryRequestDto.getGallaryId());
        BeanUtils.copyProperties(gallaryRequestDto,gallaryMaster);
        try {
            this.gallaryDao.save(gallaryMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean delete(Integer gallaryId) {
        try {
//            this.dao.deleteById(gallaryId);

            GallaryMaster gallaryMaster = new GallaryMaster();
            gallaryMaster = this.gallaryDao.findById(gallaryId).get();
            gallaryMaster.setStatus("InActive");
            System.out.println("gallary deleted successfully");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public GallaryMaster getGallaryById(Integer gallaryId) {
        GallaryMaster gallaryMaster = new GallaryMaster();
        try {
            Optional<GallaryMaster> gallaryMaster1 = this.gallaryDao.findById(gallaryId);
            gallaryMaster1.ifPresent(setting->BeanUtils.copyProperties(setting,gallaryMaster));
            return gallaryMaster;
        }catch (Exception e){
            e.printStackTrace();
            return gallaryMaster;
        }
    }

    @Override
    public List getAll() {
        return this.gallaryDao.findAll();
    }

    @Override
    public List getAllByStatus() {
        List list = this.gallaryDao.getAllByStatus("Active");
        return list;
    }

}
