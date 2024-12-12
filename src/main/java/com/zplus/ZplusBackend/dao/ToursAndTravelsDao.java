package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.model.ToursAndTravelsMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToursAndTravelsDao extends JpaRepository<ToursAndTravelsMaster,Integer> {

    List findAllByStatus(String active);
}
