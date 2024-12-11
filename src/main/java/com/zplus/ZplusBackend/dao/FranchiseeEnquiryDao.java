package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.model.FranchiseeEnquiryMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FranchiseeEnquiryDao extends JpaRepository<FranchiseeEnquiryMaster,Integer> {

    public FranchiseeEnquiryMaster findById(int franchiseeId);

    public List getAllByStatus(String Active);

    public long count();
}
