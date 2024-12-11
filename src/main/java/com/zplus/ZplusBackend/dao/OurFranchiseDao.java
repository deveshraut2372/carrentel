package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.model.OurFranchiseMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OurFranchiseDao extends JpaRepository<OurFranchiseMaster,Integer> {

    public OurFranchiseMaster findById(int franchiseId);

    public List getAllByStatus(String Active);

    public long count();
}
