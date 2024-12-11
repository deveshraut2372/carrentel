package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.model.WhyChooseUsMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhyChooseUsDao extends JpaRepository<WhyChooseUsMaster,Integer> {

    public WhyChooseUsMaster findById(int whyChooseUsId);

    public List findAllByStatus(String Active);
}
