package com.zplus.ZplusBackend.controller;



import com.zplus.ZplusBackend.dto.req.ToursAndTravelsDetailsReq;
import com.zplus.ZplusBackend.dto.res.MainResDto;


import com.zplus.ZplusBackend.model.ToursAndTravelsDetails;
import com.zplus.ZplusBackend.service.ToursAndTravelsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/toursAndTravelsDetails")
public class ToursAndTravelsDetailsController {

    @Autowired
    private ToursAndTravelsDetailsService toursAndTravelsDetailsService;



    @PostMapping("/create")
    public ResponseEntity create(@RequestBody ToursAndTravelsDetailsReq toursAndTravelsDetailsReq)
    {
        Boolean flag = this.toursAndTravelsDetailsService.create(toursAndTravelsDetailsReq);
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
    public ResponseEntity update(@RequestBody ToursAndTravelsDetailsReq toursAndTravelsReq)
    {
        try{
            Boolean flag = this.toursAndTravelsDetailsService.update(toursAndTravelsReq);
            return new ResponseEntity<>(flag,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{toursAndTraveDetailsId}")
    public ResponseEntity getById(@PathVariable("toursAndTraveDetailsId") Integer toursAndTraveDetailsId)
    {
        try {
            ToursAndTravelsDetails toursAndTravelsDetails = this.toursAndTravelsDetailsService.getById(toursAndTraveDetailsId);
            return new ResponseEntity<>(toursAndTravelsDetails,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll()
    {
        try {
            List list = this.toursAndTravelsDetailsService.getAll();
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
            List list = this.toursAndTravelsDetailsService.getAllByStatus();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByToursAndTraveId/{toursAndTraveId}")
    public ResponseEntity getByToursAndTraveId(@PathVariable("toursAndTraveId") Integer toursAndTraveId)
    {
        try {
            List<ToursAndTravelsDetails> toursAndTravelsDetailsList = this.toursAndTravelsDetailsService.getByToursAndTraveId(toursAndTraveId);
            return new ResponseEntity<>(toursAndTravelsDetailsList,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
