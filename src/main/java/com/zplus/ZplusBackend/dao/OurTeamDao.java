package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.model.OurTeamMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OurTeamDao extends JpaRepository<OurTeamMaster,Integer> {

    public OurTeamMaster findById(int teamId);

    public List findAllByStatus(String Active);
}
