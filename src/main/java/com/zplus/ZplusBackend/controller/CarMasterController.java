package com.zplus.ZplusBackend.controller;


import com.zplus.ZplusBackend.dto.req.BannerRequestDto;
import com.zplus.ZplusBackend.dto.req.CarMasterReq;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.BannerMaster;
import com.zplus.ZplusBackend.model.CarMaster;
import com.zplus.ZplusBackend.service.CarMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/api/CarMaster")
public class CarMasterController {

    @Autowired
    private CarMasterService carMasterService;

    @PostMapping
    public ResponseEntity create(@RequestBody CarMasterReq carMasterReq)
    {
        Boolean flag = this.carMasterService.create(carMasterReq);
        MainResDto mainResDto=new MainResDto();
        if(Boolean.TRUE.equals(flag))
        {
            mainResDto.setFlag(flag);
            mainResDto.setMessage(" car Created Succesfully");
            mainResDto.setResponseCode(HttpStatus.OK.value());
            return new ResponseEntity(flag, HttpStatus.OK);
        }else{
            mainResDto.setFlag(flag);
            mainResDto.setMessage(" Car Does Not  Created");
            mainResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity(flag,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity update(@RequestBody CarMasterReq carMasterReq)
    {
        try{
            Boolean flag = this.carMasterService.update(carMasterReq);
            return new ResponseEntity<>(flag,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{carId}")
    public ResponseEntity getById(@PathVariable("carId") Integer carId)
    {
        try {
            CarMaster carMaster = this.carMasterService.getById(carId);
            return new ResponseEntity<>(carMaster,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity getAll()
    {
        try {
            List list = this.carMasterService.getAll();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllByStatus")
    public ResponseEntity getAllByStatus()
    {
        try {
            List list = this.carMasterService.getAllByStatus();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
