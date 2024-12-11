package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.model.AdminMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminDao extends JpaRepository<AdminMaster,Integer> {

    public AdminMaster findById(int adminId);

    AdminMaster findByEmailOrMobile(String username, String username1);

    @Query("update AdminMaster as am set am.otp=:otp where am.adminId=:adminId")
    public Integer updateOtp(@Param("adminId") Integer adminId, @Param("otp") Integer otp);


}
