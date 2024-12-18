package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.dto.res.CarTPermitRes;
import com.zplus.ZplusBackend.model.CarTPermitMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;


public interface CarTPermitDao extends JpaRepository<CarTPermitMaster,Integer> {
    List<CarTPermitMaster> findAllByStatus(String active);


    @Query("select new com.zplus.ZplusBackend.dto.res.CarTPermitRes(ctp.carTPermitId,ctp.image,ctp.title,ctp.status,ctp.date)  from CarTPermitMaster as ctp where ctp.carTPermitId=:carTPermitId ")
    CarTPermitRes getByCarcar(@Param("carTPermitId") Integer carTPermitId);

}
