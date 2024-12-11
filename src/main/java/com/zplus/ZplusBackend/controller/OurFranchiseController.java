package com.zplus.ZplusBackend.controller;

import com.zplus.ZplusBackend.dto.req.OurFranchiseRequestDto;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.OurFranchiseMaster;
import com.zplus.ZplusBackend.service.OurFranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ourFranchise")
public class OurFranchiseController {

    @Autowired
    private OurFranchiseService ourFranchiseService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody OurFranchiseRequestDto ourFranchiseRequestDto)
    {
        MainResDto mainResDto = this.ourFranchiseService.create(ourFranchiseRequestDto);
        return new ResponseEntity<>(mainResDto, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody OurFranchiseRequestDto ourFranchiseRequestDto)
    {
        try {
            MainResDto mainResDto = this.ourFranchiseService.update(ourFranchiseRequestDto);
            return new ResponseEntity(mainResDto,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getOurFranchiseById/{ourFranchiseId}")
    public ResponseEntity getById(@PathVariable("ourFranchiseId") Integer ourFranchiseId)
    {
        OurFranchiseMaster ourFranchiseMaster =this.ourFranchiseService.findById(ourFranchiseId);
        return new ResponseEntity<>(ourFranchiseMaster,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll()
    {
        List list = this.ourFranchiseService.getAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/getAllByStatus")
    public ResponseEntity getAllByStatus()
    {
        List list = this.ourFranchiseService.getAllByStatus();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/getCount")
    public ResponseEntity getCount()
    {
        long count = this.ourFranchiseService.getCount();
        return new ResponseEntity<>(count,HttpStatus.OK);
    }
}
