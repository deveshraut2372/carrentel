package com.zplus.ZplusBackend.controller;

import com.zplus.ZplusBackend.dto.req.CarTPermitReq;
import com.zplus.ZplusBackend.dto.res.CarTPermitRes;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.CarTPermitMaster;
import com.zplus.ZplusBackend.service.CarTPermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/CarTPermit")
@CrossOrigin(origins = "*")
public class CarTPermitController {

    @Autowired
    private CarTPermitService carTPermitService;

    @PostMapping(value = "/create")
    private ResponseEntity createCarTPermit(@RequestBody CarTPermitReq carTPermitReq)
    {
        MainResDto mainResDto=new MainResDto();
        mainResDto=carTPermitService.createCarTPermit(carTPermitReq);
        if(mainResDto.getFlag())
        {
            return new ResponseEntity<>(mainResDto,HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(mainResDto,HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping(value = "/update")
    private ResponseEntity updateCarTPermit(@RequestBody CarTPermitReq carTPermitReq)
    {
        MainResDto mainResDto=new MainResDto();
        mainResDto=carTPermitService.updateCarTPermit(carTPermitReq);
        if(mainResDto.getFlag())
        {
            return new ResponseEntity<>(mainResDto,HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(mainResDto,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity getAll()
    {
        List<CarTPermitRes> carTPermitResList=new ArrayList<>();
        carTPermitResList=carTPermitService.getAll();
        return new ResponseEntity(carTPermitResList,HttpStatus.OK);
    }


    @GetMapping(value = "/getActiveAll")
    public ResponseEntity<CarTPermitMaster> getActiveAll()
    {
        List<CarTPermitRes> carTPermitResList=new ArrayList<>();
        carTPermitResList=carTPermitService.getActiveAll();
        return new ResponseEntity(carTPermitResList,HttpStatus.OK);
    }

    @GetMapping(value = "/getByCarTPermitId/{carTPermitId}")
    public ResponseEntity getByCarTPermitId(@PathVariable("carTPermitId") Integer carTPermitId)
    {
        CarTPermitRes carTPermitRes=new CarTPermitRes();
        carTPermitRes=carTPermitService.getByCarTPermitId(carTPermitId);
        return new ResponseEntity(carTPermitRes,HttpStatus.OK);
    }

    @GetMapping(value = "/DeleteByCarTPermitId/{carTPermitId}")
    public ResponseEntity DeleteByCarTPermitId(@PathVariable("carTPermitId") Integer carTPermitId)
    {
        Boolean flag;
        flag=carTPermitService.DeleteByCarTPermitId(carTPermitId);
        return new ResponseEntity(flag,HttpStatus.OK);
    }


}
