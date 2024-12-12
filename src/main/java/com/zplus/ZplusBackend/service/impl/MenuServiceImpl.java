package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.MenuDao;
import com.zplus.ZplusBackend.dto.req.MenuRequestDto;
import com.zplus.ZplusBackend.model.MenuMaster;
import com.zplus.ZplusBackend.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;
    @Override
    public Boolean create(MenuRequestDto menuRequestDto) {
        MenuMaster menuMaster = new MenuMaster();
        try {
            BeanUtils.copyProperties(menuRequestDto,menuMaster);
            this.menuDao.save(menuMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(MenuRequestDto menuRequestDto) {
        MenuMaster menuMaster = new MenuMaster();

        menuMaster.setMenuId(menuRequestDto.getMenuId());
        BeanUtils.copyProperties(menuRequestDto,menuMaster);
        try {
            this.menuDao.save(menuMaster);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean delete(Integer menuId) {
        try{
//            this.menuDao.deleteById(menuId);
            MenuMaster menuMaster = new MenuMaster();
            menuMaster = this.menuDao.findById(menuId).orElse(null);
            menuMaster.setStatus("InActive");
            System.out.println("menu deleted successfully");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public MenuMaster findMenu(Integer menuId) {
        MenuMaster menuMaster = new MenuMaster();
        try {
            Optional<MenuMaster> menuMaster1 = this.menuDao.findById(menuId);
            menuMaster1.ifPresent(setting->BeanUtils.copyProperties(setting,menuMaster));
            return menuMaster;
        }catch (Exception e){
            e.printStackTrace();
            return menuMaster;
        }
    }

    @Override
    public List getAll() {
        return this.menuDao.findAll();
    }

    @Override
    public List getAllByStatus() {
        List list = this.menuDao.getAllByStatus("Active");
        return list;
    }
}
