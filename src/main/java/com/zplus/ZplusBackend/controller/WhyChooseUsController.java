package com.zplus.ZplusBackend.controller;


import com.zplus.ZplusBackend.dto.req.WhyChooseUsRequestDto;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.WhyChooseUsMaster;
import com.zplus.ZplusBackend.service.impl.WhyChooseUsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/whyChooseUs")
public class WhyChooseUsController {

    @Autowired
    private WhyChooseUsServiceImpl whyChooseUsService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody WhyChooseUsRequestDto whyChooseUsRequestDto)
    {
        try {
            MainResDto mainResDto = this.whyChooseUsService.create(whyChooseUsRequestDto);
            return new ResponseEntity<>(mainResDto, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody WhyChooseUsRequestDto whyChooseUsRequestDto)
    {
        try {
            MainResDto mainResDto= this.whyChooseUsService.update(whyChooseUsRequestDto);
            return new ResponseEntity<>(mainResDto,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{whyChooseUsId}")
    public ResponseEntity getById(@PathVariable("whyChooseUsId") Integer whyChooseUsId)
    {
        WhyChooseUsMaster whyChooseUsMaster = this.whyChooseUsService.findById(whyChooseUsId);
        return new ResponseEntity<>(whyChooseUsMaster,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll()
    {
        List list =this.whyChooseUsService.getAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/getAllActive")
    public ResponseEntity getAllActive()
    {
        List list = this.whyChooseUsService.getAllActive();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
