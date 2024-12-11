package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.model.BannerMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BannerDao extends JpaRepository<BannerMaster,Integer> {

    public BannerMaster findById(int bannerId);

    public List getAllByStatus(String Active);

}
