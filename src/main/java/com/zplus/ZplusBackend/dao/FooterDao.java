package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.model.FooterMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FooterDao extends JpaRepository<FooterMaster,Integer> {

    public FooterMaster findById(int footerId);

    public List getAllByStatus(String Active);
}
