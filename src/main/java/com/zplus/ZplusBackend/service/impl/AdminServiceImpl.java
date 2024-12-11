package com.zplus.ZplusBackend.service.impl;

import com.zplus.ZplusBackend.dao.AdminDao;
import com.zplus.ZplusBackend.dto.req.AdminLoginRequestDto;
import com.zplus.ZplusBackend.dto.req.AdminRequestDto;
import com.zplus.ZplusBackend.dto.res.AdminLoginResponseDto;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.AdminMaster;
import com.zplus.ZplusBackend.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;



    /*  Create Admin  */
    @Override
    public MainResDto create(AdminRequestDto adminRequestDto) {

        AdminMaster adminMaster = this.adminDao.findByEmailOrMobile(adminRequestDto.getEmail(),adminRequestDto.getMobile());
        System.out.println(adminMaster);
        MainResDto mainResDto = new MainResDto();
        AdminMaster admin1 = new AdminMaster();

            if(adminMaster!=null)
            {
                mainResDto.setMessage("Admin already present please enter another email or mobile");
                mainResDto.setFlag(false);
                mainResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
                return mainResDto;
            }else{
                this.adminDao.findByEmailOrMobile(admin1.getEmail(),admin1.getMobile());
                BeanUtils.copyProperties(adminRequestDto,admin1);
                admin1.setDate(new Date());
//                admin1.setStatus("Active");
                this.adminDao.save(admin1);
                System.out.println("admin created successfully");
                mainResDto.setFlag(true);
                mainResDto.setMessage("Admin created successfully");
                mainResDto.setResponseCode(HttpStatus.OK.value());
                return mainResDto;
            }
    }

    /*  Update Admin  */
    @Override
    public MainResDto update(AdminRequestDto adminRequestDto) {
        AdminMaster admin = new AdminMaster();
        MainResDto mainResDto = new MainResDto();
        try {
            admin.setAdminId(adminRequestDto.getAdminId());
            BeanUtils.copyProperties(adminRequestDto,admin);
            admin.setDate(new Date());
//            admin.setStatus("Active");
            this.adminDao.save(admin);
            mainResDto.setMessage("Admin updated successfully");
            mainResDto.setFlag(true);
            mainResDto.setResponseCode(HttpStatus.OK.value());
            return mainResDto;
        }catch (Exception e){
            e.printStackTrace();
            mainResDto.setMessage("Admin didn't updated");
            mainResDto.setFlag(false);
            mainResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            return mainResDto;
        }
    }

    /*  Delete Admin By ID */
    @Override
    public Boolean delete(Integer adminId) {
        try {
//            this.dao.deleteById(adminId);
            AdminMaster adminMaster = new AdminMaster();
            adminMaster=this.adminDao.findById(adminId).get();
            adminMaster.setStatus("InActive");
            this.adminDao.save(adminMaster);
            System.out.println("Admin deleted successfully");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*  Get All Admins  */
    @Override
    public List getAllAdmins() {
        return this.adminDao.findAll();
    }


    /*  Get Admin By ID */
    @Override
    public AdminMaster getAdminById(Integer adminId) {
        AdminMaster admin = new AdminMaster();
        try {
            Optional<AdminMaster> admin1 = this.adminDao.findById(adminId);
            admin1.ifPresent(setting->BeanUtils.copyProperties(setting,admin));
            return admin;
        }catch (Exception e){
            e.printStackTrace();
            return admin;
        }
    }

    /*  Admin Login */
    @Override
    public AdminLoginResponseDto login(AdminLoginRequestDto adminLoginRequestDto) {
        AdminLoginResponseDto adminLoginResponseDto = new AdminLoginResponseDto();
        AdminMaster admin = this.adminDao.findByEmailOrMobile(adminLoginRequestDto.getUsername(),adminLoginRequestDto.getUsername());

        if(admin==null)
        {
            adminLoginResponseDto.setMessage("Admin mobile number or email not exist");
            adminLoginResponseDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            return adminLoginResponseDto;
        }

        if(admin.getEmail().equalsIgnoreCase(adminLoginRequestDto.getUsername()) || admin.getMobile().equalsIgnoreCase(adminLoginRequestDto.getUsername()))
        {
            if(admin.getPassword().equals(adminLoginRequestDto.getPassword()))
            {
                if(admin.getStatus().equals("Active"))
                {
                    adminLoginResponseDto.setMessage("Login successfully");
                    adminLoginResponseDto.setResponseCode(HttpStatus.OK.value());
                    return adminLoginResponseDto;
                }else{
                    adminLoginResponseDto.setMessage("Admin is not active");
                    adminLoginResponseDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
                    return adminLoginResponseDto;
                }
            }else{
                adminLoginResponseDto.setMessage("Wrong password please try again...");
                adminLoginResponseDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
                return adminLoginResponseDto;
            }
        }else{
            adminLoginResponseDto.setMessage("Admin Mobile number or Email Not found");
            adminLoginResponseDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            return adminLoginResponseDto;
        }
    }
}
