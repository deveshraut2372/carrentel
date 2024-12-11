package com.zplus.ZplusBackend.controller;

import com.zplus.ZplusBackend.dto.req.AdminLoginRequestDto;
import com.zplus.ZplusBackend.dto.req.AdminRequestDto;
import com.zplus.ZplusBackend.dto.res.AdminLoginResponseDto;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.AdminMaster;
import com.zplus.ZplusBackend.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("/create")
    public ResponseEntity createAdmin(@RequestBody AdminRequestDto adminRequestDto) {
        try {
            MainResDto mainResDto = this.adminService.create(adminRequestDto);
            return new ResponseEntity<>(mainResDto,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/update")
    public ResponseEntity updateAdmin(@RequestBody AdminRequestDto adminRequestDto)
    {
        AdminMaster adminMaster = new AdminMaster();
        try {
            MainResDto  mainResDto = this.adminService.update(adminRequestDto);
            return new ResponseEntity<>(mainResDto,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete/{adminId}")
    public ResponseEntity deleteAdmin(@PathVariable("adminId") Integer adminId)
    {
        Boolean flag = this.adminService.delete(adminId);

        if(Boolean.TRUE.equals(flag)) {
            return new ResponseEntity(flag, HttpStatus.OK);
        }
        else{
            return new ResponseEntity(flag, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllAdmins")
    public ResponseEntity getAllAdmins()
    {
        try {
            List list = this.adminService.getAllAdmins();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAdmin/{adminId}")
    public ResponseEntity getAdminById(@PathVariable("adminId") Integer adminId)
    {
        try {
            AdminMaster admin = adminService.getAdminById(adminId);
            return new ResponseEntity<>(admin,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity adminLogin(@RequestBody AdminLoginRequestDto adminLoginRequestDto)
    {
        try {
            AdminLoginResponseDto adminLoginResponseDto = this.adminService.login(adminLoginRequestDto);
            return new ResponseEntity<>(adminLoginResponseDto,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
