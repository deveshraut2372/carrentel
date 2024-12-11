package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.model.SightMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SightsMasterDao extends JpaRepository<SightMaster,Integer> {

    List findAllByStatus(String status);

    List findAllByLocationMaster_LocationId(Integer locationId);
}
