package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.model.ContactUsMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactUsDao extends JpaRepository<ContactUsMaster,Integer> {

    public ContactUsMaster findById(int contactId);

    public long count();
}
