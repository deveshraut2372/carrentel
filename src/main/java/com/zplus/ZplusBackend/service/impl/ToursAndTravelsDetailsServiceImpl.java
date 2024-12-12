package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.ToursAndTravelsDao;
import com.zplus.ZplusBackend.dao.ToursAndTravelsDetailsDao;
import com.zplus.ZplusBackend.dto.req.ToursAndTravelsDetailsReq;
import com.zplus.ZplusBackend.model.ToursAndTravelsDetails;
import com.zplus.ZplusBackend.model.ToursAndTravelsMaster;
import com.zplus.ZplusBackend.service.ToursAndTravelsDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ToursAndTravelsDetailsServiceImpl implements ToursAndTravelsDetailsService {

    @Autowired
    private ToursAndTravelsDetailsDao toursAndTravelsDetailsDao;

    @Autowired
    private ToursAndTravelsDao toursAndTravelsDao;



    @Override
    public Boolean create(ToursAndTravelsDetailsReq toursAndTravelsDetailsReq) {

        ToursAndTravelsDetails toursAndTravelsDetails=new ToursAndTravelsDetails();
        BeanUtils.copyProperties(toursAndTravelsDetailsReq,toursAndTravelsDetails);
        toursAndTravelsDetails.setStatus("Active");
        toursAndTravelsDetails.setDate(new Date());

        ToursAndTravelsMaster toursAndTravelsMaster=toursAndTravelsDao.findById(toursAndTravelsDetailsReq.getToursAndTraveId()).orElse(null);
        toursAndTravelsDetails.setToursAndTravelsMaster(toursAndTravelsMaster);

        try
        {
            toursAndTravelsDetailsDao.save(toursAndTravelsDetails);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(ToursAndTravelsDetailsReq toursAndTravelsDetailsReq) {

        ToursAndTravelsDetails toursAndTravelsDetails=new ToursAndTravelsDetails();
        BeanUtils.copyProperties(toursAndTravelsDetailsReq,toursAndTravelsDetails);
        toursAndTravelsDetails.setDate(new Date());
        toursAndTravelsDetails.setToursAndTraveDetailsId(toursAndTravelsDetailsReq.getToursAndTraveDetailsId());
        ToursAndTravelsMaster toursAndTravelsMaster=toursAndTravelsDao.findById(toursAndTravelsDetailsReq.getToursAndTraveId()).orElse(null);
        toursAndTravelsDetails.setToursAndTravelsMaster(toursAndTravelsMaster);

        try
        {
            toursAndTravelsDetailsDao.save(toursAndTravelsDetails);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getAll() {
        return toursAndTravelsDetailsDao.findAll();
    }

    @Override
    public List getAllByStatus() {
        return toursAndTravelsDetailsDao.findAllByStatus("Active");
    }

    @Override
    public ToursAndTravelsDetails getById(Integer toursAndTraveDetailsId) {
        return toursAndTravelsDetailsDao.findById(toursAndTraveDetailsId).orElse(null);
    }

    @Override
    public List<ToursAndTravelsDetails> getByToursAndTraveId(Integer toursAndTraveId) {

        List<ToursAndTravelsDetails> toursAndTravelsDetailsList=new ArrayList<>();

        toursAndTravelsDetailsList=toursAndTravelsDetailsDao.getByToursAndTraveId(toursAndTraveId);

        return toursAndTravelsDetailsList;
    }
}
