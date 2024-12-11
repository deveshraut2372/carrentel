package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.model.CarMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarMasterDao extends JpaRepository<CarMaster,Integer> {
    List findAllByStatus(String active);
}
