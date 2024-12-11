package com.zplus.ZplusBackend.controller;

import com.zplus.ZplusBackend.dto.req.BannerRequestDto;
import com.zplus.ZplusBackend.dto.req.SightsMasterReq;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.BannerMaster;
import com.zplus.ZplusBackend.model.SightMaster;
import com.zplus.ZplusBackend.service.SightsMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/sightsMaster")
public class SightsMasterController {


    @Autowired
    private SightsMasterService sightsMasterService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody SightsMasterReq sightsMasterReq)
    {
        Boolean flag = this.sightsMasterService.create(sightsMasterReq);
        MainResDto mainResDto=new MainResDto();
        if(Boolean.TRUE.equals(flag))
        {
            mainResDto.setFlag(flag);
            mainResDto.setMessage(" Sight Created Succesfully");
            mainResDto.setResponseCode(HttpStatus.OK.value());
            return new ResponseEntity(flag, HttpStatus.OK);
        }else{
            mainResDto.setFlag(flag);
            mainResDto.setMessage(" Sight Does Not  Created");
            mainResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity(flag,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody SightsMasterReq sightsMasterReq)
    {
        try{
            Boolean flag = this.sightsMasterService.update(sightsMasterReq);
            return new ResponseEntity<>(flag,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{sightId}")
    public ResponseEntity getById(@PathVariable("sightId") Integer sightId)
    {
        try {
            SightMaster sightsMaster = this.sightsMasterService.getById(sightId);
            return new ResponseEntity<>(sightsMaster,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity getAll()
    {
        try {
            List list = this.sightsMasterService.getAll();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllActiveSights")
    public ResponseEntity getAllByStatus(@PathVariable("status") String status)
    {
        try {
            List list = this.sightsMasterService.getAllByStatus(status);
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllSightsBylocationId/{locationId}")
    public ResponseEntity getAllSightsBylocationId(@PathVariable("locationId") Integer locationId)
    {
        try {
            List list = this.sightsMasterService.getAllSightsBylocationId(locationId);
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}
