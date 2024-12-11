package com.zplus.ZplusBackend.dao;


import com.zplus.ZplusBackend.model.AboutUsMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AboutUsDao extends JpaRepository<AboutUsMaster,Integer> {

    public AboutUsMaster findById(int aboutUsId);

    public List findAllByStatus(String active);
}
