package com.zplus.ZplusBackend.service;



import com.zplus.ZplusBackend.dto.req.AdminLoginRequestDto;
import com.zplus.ZplusBackend.dto.req.AdminRequestDto;
import com.zplus.ZplusBackend.dto.res.AdminLoginResponseDto;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.AdminMaster;

import java.util.List;

public interface AdminService {

    public MainResDto create(AdminRequestDto adminRequestDto);


    public MainResDto update(AdminRequestDto adminRequestDto);

    public Boolean delete(Integer adminId);

    public List getAllAdmins();
//
    public AdminMaster getAdminById(Integer adminId);
//
    public AdminLoginResponseDto login(AdminLoginRequestDto adminLoginRequestDto);
}
