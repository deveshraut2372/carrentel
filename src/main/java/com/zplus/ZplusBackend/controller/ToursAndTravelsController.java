package com.zplus.ZplusBackend.controller;

import com.zplus.ZplusBackend.dto.ToursAndTravelsReq;
import com.zplus.ZplusBackend.dto.req.BannerRequestDto;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.BannerMaster;
import com.zplus.ZplusBackend.model.ToursAndTravelsMaster;
import com.zplus.ZplusBackend.service.ToursAndTravelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/toursAndTravels")
public class ToursAndTravelsController {

    @Autowired
    private ToursAndTravelsService toursAndTravelsService;



    @PostMapping("/create")
    public ResponseEntity create(@RequestBody ToursAndTravelsReq toursAndTravelsReq)
    {
        Boolean flag = this.toursAndTravelsService.create(toursAndTravelsReq);
        MainResDto mainResDto=new MainResDto();
        if(Boolean.TRUE.equals(flag))
        {
            mainResDto.setFlag(flag);
            mainResDto.setMessage("  Created Succesfully");
            mainResDto.setResponseCode(HttpStatus.OK.value());
            return new ResponseEntity(flag, HttpStatus.OK);
        }else{
            mainResDto.setFlag(flag);
            mainResDto.setMessage("  Does Not  Created");
            mainResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity(flag,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody ToursAndTravelsReq toursAndTravelsReq)
    {
        try{
            Boolean flag = this.toursAndTravelsService.update(toursAndTravelsReq);
            return new ResponseEntity<>(flag,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{toursAndTraveId}")
    public ResponseEntity getById(@PathVariable("toursAndTraveId") Integer toursAndTraveId)
    {
        try {
            ToursAndTravelsMaster toursAndTravelsMaster = this.toursAndTravelsService.getById(toursAndTraveId);
            return new ResponseEntity<>(toursAndTravelsMaster,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll()
    {
        try {
            List list = this.toursAndTravelsService.getAll();
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
            List list = this.toursAndTravelsService.getAllByStatus();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }



}
