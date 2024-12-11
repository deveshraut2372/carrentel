package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.model.LocationMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationMasterDao extends JpaRepository<LocationMaster,Integer> {
    List findAllByStatus(String status);
}
