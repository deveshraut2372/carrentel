package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.model.GallaryMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GallaryDao extends JpaRepository<GallaryMaster,Integer> {

    public GallaryMaster findById(int gallaryId);

    public List getAllByStatus(String Active);
}
