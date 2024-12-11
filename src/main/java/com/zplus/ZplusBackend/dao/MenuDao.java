package com.zplus.ZplusBackend.dao;

import com.zplus.ZplusBackend.model.MenuMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuDao extends JpaRepository<MenuMaster,Integer> {

    public MenuMaster findById(int menuId);

    public List getAllByStatus(String Active);
}
