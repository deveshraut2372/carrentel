package com.zplus.ZplusBackend.service;


import com.zplus.ZplusBackend.dto.req.MenuRequestDto;
import com.zplus.ZplusBackend.model.MenuMaster;

import java.util.List;

public interface MenuService {

    public Boolean create(MenuRequestDto menuRequestDto);

    public Boolean update(MenuRequestDto menuRequestDto);

    public Boolean delete(Integer menuId);

    public MenuMaster findMenu(Integer menuId);

    public List getAll();

    public List getAllByStatus();
}
