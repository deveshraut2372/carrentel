package com.zplus.ZplusBackend.service.impl;


import com.zplus.ZplusBackend.dao.CarTPointDao;
import com.zplus.ZplusBackend.service.CartTPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartTPointServiceImpl implements CartTPointService {

    @Autowired
    private CarTPointDao carTPointDao;

}
