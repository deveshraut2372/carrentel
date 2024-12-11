package com.zplus.ZplusBackend.controller;


import com.zplus.ZplusBackend.dto.LocationMasterReq;
import com.zplus.ZplusBackend.dto.req.BannerRequestDto;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.BannerMaster;
import com.zplus.ZplusBackend.model.LocationMaster;
import com.zplus.ZplusBackend.service.LocationService;
import com.zplus.ZplusBackend.service.impl.BannerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/locationMaster")
public class LocationController {


    @Autowired
    private LocationService locationService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody LocationMasterReq locationMasterReq)
    {
        Boolean flag = this.locationService.create(locationMasterReq);
        MainResDto mainResDto=new MainResDto();
        if(Boolean.TRUE.equals(flag))
        {
            mainResDto.setFlag(flag);
            mainResDto.setMessage(" Location Created Succesfully");
            mainResDto.setResponseCode(HttpStatus.OK.value());
            return new ResponseEntity(flag, HttpStatus.OK);
        }else{
            mainResDto.setFlag(flag);
            mainResDto.setMessage(" Location Does Not  Created");
            mainResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity(flag,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody LocationMasterReq locationMasterReq)
    {
        try{
            Boolean flag = this.locationService.update(locationMasterReq);
            return new ResponseEntity<>(flag,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{locationId}")
    public ResponseEntity getById(@PathVariable("locationId") Integer locationId)
    {
        try {
            LocationMaster locationMaster = this.locationService.getById(locationId);
            return new ResponseEntity<>(locationMaster,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll()
    {
        try {
            List list = this.locationService.getAll();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllByStatus/{status}")
    public ResponseEntity getAllByStatus(@PathVariable("status") String status)
    {
        try {
            List list = this.locationService.getAllByStatus(status);
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
