package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.model.CarTPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarTPointDao extends JpaRepository<CarTPoint,Integer> {

    @Query("select ctp from CarTPoint as ctp where ctp.carTPermitMaster.carTPermitId=:carTPermitId")
    List<CarTPoint> getAllByCartPermitId(@Param("carTPermitId") Integer carTPermitId);

    @Query("Select ctp.point from CarTPoint as ctp where ctp.carTPermitMaster.carTPermitId=:carTPermitId ")
    List<String> getAllCarTpoints(@Param("carTPermitId") Integer carTPermitId);
}
