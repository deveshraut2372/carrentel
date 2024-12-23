package com.zplus.ZplusBackend.dao;


import com.zplus.ZplusBackend.dto.res.ConnectWithUsResDto;
import com.zplus.ZplusBackend.model.ConnectWithUsMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ConnectWithUsDao extends JpaRepository<ConnectWithUsMaster,Integer> {

    List<ConnectWithUsMaster> findAllByStatus(String active);

    @Query("Select new com.zplus.ZplusBackend.dto.res.ConnectWithUsResDto(cws.connectWithUsId,cws.fullName,cws.phoneNumber,cws.userEmail,cws.address,cws.cartype,cws.status,cws.date,cws.carTPermitId) from ConnectWithUsMaster as cws where cws.connectWithUsId=:connectWithUsId")
    ConnectWithUsResDto getData(@Param("connectWithUsId") Integer connectWithUsId);

    @Query("Select new com.zplus.ZplusBackend.dto.res.ConnectWithUsResDto(cws.connectWithUsId,cws.fullName,cws.phoneNumber,cws.userEmail,cws.address,cws.cartype,cws.status,cws.date,cws.carTPermitId) from ConnectWithUsMaster as cws where cws.status=:active")
    List<ConnectWithUsResDto> getByStatus(@Param("active")String active);

    @Query("Select new com.zplus.ZplusBackend.dto.res.ConnectWithUsResDto(cws.connectWithUsId,cws.fullName,cws.phoneNumber,cws.userEmail,cws.address,cws.cartype,cws.status,cws.date,cws.carTPermitId) from ConnectWithUsMaster as cws where cws.carTPermitId=:carTPermitId")
    List<ConnectWithUsResDto> getAllByCarTPermitId(@Param("carTPermitId")Integer carTPermitId);
}

