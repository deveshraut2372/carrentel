package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.AboutUsDao;
import com.zplus.ZplusBackend.dto.req.AboutUsRequestDto;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.AboutUsMaster;
import com.zplus.ZplusBackend.service.AboutUsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AboutUsServiceImpl implements AboutUsService {

    @Autowired
    private AboutUsDao aboutUsDao;


    /*  Create About Us  */
    @Override
    public MainResDto create(AboutUsRequestDto aboutUsRequestDto) {
        AboutUsMaster aboutUsMaster = new AboutUsMaster();
        BeanUtils.copyProperties(aboutUsRequestDto,aboutUsMaster);
        MainResDto mainResDto = new MainResDto();

        try {
//            aboutUsMaster.setStatus("Active");
            this.aboutUsDao.save(aboutUsMaster);
            mainResDto.setMessage("About us created successfully");
            mainResDto.setFlag(true);
            mainResDto.setResponseCode(HttpStatus.OK.value());
            return mainResDto;
        }catch (Exception e){
            e.printStackTrace();
            mainResDto.setMessage("About us didn't created");
            mainResDto.setFlag(false);
            mainResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            return mainResDto;
        }
    }

    /*  Update About Us  */

    @Override
    public Boolean update(AboutUsRequestDto aboutUsRequestDto) {
        AboutUsMaster aboutUsMaster = new AboutUsMaster();
        try {
            aboutUsMaster.setAboutUsId(aboutUsRequestDto.getAboutUsId());
            BeanUtils.copyProperties(aboutUsRequestDto,aboutUsMaster);
            this.aboutUsDao.save(aboutUsMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    /*  Delete About Us  */
    @Override
    public Boolean delete(Integer aboutUsId) {
        try {
            AboutUsMaster aboutUsMaster = new AboutUsMaster();
            aboutUsMaster=this.aboutUsDao.findById(aboutUsId).get();
            aboutUsMaster.setStatus("InActive");
            this.aboutUsDao.save(aboutUsMaster);
//            this.dao.deleteById(aboutUsId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*  Get About Us By ID */
    @Override
    public AboutUsMaster getById(Integer aboutUsId) {
        AboutUsMaster aboutUsMaster = new AboutUsMaster();

        try {
            Optional<AboutUsMaster> aboutUsMaster1=this.aboutUsDao.findById(aboutUsId);
            aboutUsMaster1.ifPresent(setting->BeanUtils.copyProperties(setting,aboutUsMaster));
            return aboutUsMaster;
        }catch (Exception e){
            e.printStackTrace();
            return aboutUsMaster;
        }
    }

    /*  Get All About Us  */
    @Override
    public List getAll() {
        return this.aboutUsDao.findAll();
    }

    /*  Get All About Us By Status */
    @Override
    public List getAllByStatus() {
        return this.aboutUsDao.findAllByStatus("Active");
    }
}
