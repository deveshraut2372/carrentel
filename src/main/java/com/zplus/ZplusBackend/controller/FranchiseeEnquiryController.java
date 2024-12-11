package com.zplus.ZplusBackend.controller;

import com.zplus.ZplusBackend.dto.req.FranchiseeEnquiryRequestDto;
import com.zplus.ZplusBackend.model.FranchiseeEnquiryMaster;
import com.zplus.ZplusBackend.service.impl.FranchiseeEnquiryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/franchisee")
public class FranchiseeEnquiryController {

    @Autowired
    private FranchiseeEnquiryServiceImpl franchiseeEnquiryService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody FranchiseeEnquiryRequestDto franchiseeEnquiryRequestDto)
    {
        Boolean flag = this.franchiseeEnquiryService.create(franchiseeEnquiryRequestDto);

        if(Boolean.TRUE.equals(flag))
        {
            return new ResponseEntity<>(flag, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(flag,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody FranchiseeEnquiryRequestDto franchiseeEnquiryRequestDto)
    {
        try {
            Boolean flag = this.franchiseeEnquiryService.update(franchiseeEnquiryRequestDto);
            return new ResponseEntity<>(flag,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getById/{franchiseeId}")
    public ResponseEntity getFranchiseeById(@PathVariable("franchiseeId") Integer franchiseeId)
    {
        FranchiseeEnquiryMaster franchiseeEnquiryMaster = this.franchiseeEnquiryService.getById(franchiseeId);
        return new ResponseEntity<>(franchiseeEnquiryMaster,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll()
    {
        List list = this.franchiseeEnquiryService.getAll();
        return new ResponseEntity(list,HttpStatus.OK);
    }

    @GetMapping("/getAllByStatus")
    public ResponseEntity getAllByStatus()
    {
        List list = this.franchiseeEnquiryService.getAllByStatus();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/getCount")
    public ResponseEntity getCount()
    {
        Long count = this.franchiseeEnquiryService.getCount();
        return new ResponseEntity<>(count,HttpStatus.OK);
    }
}
