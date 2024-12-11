package com.zplus.ZplusBackend.controller;

import com.zplus.ZplusBackend.dto.req.FooterRequestDto;
import com.zplus.ZplusBackend.model.FooterMaster;
import com.zplus.ZplusBackend.service.impl.FooterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/footer")
public class FooterController {
    @Autowired
    private FooterServiceImpl footerService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody FooterRequestDto footerRequestDto)
    {
        Boolean flag = this.footerService.create(footerRequestDto);

        if(Boolean.TRUE.equals(flag)){
            return new ResponseEntity<>(flag, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(flag,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody FooterRequestDto footerRequestDto)
    {
        try {
            Boolean flag = this.footerService.update(footerRequestDto);
            return new ResponseEntity<>(flag,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll()
    {
        List list = this.footerService.getAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/getAllByStatus")
    public ResponseEntity getAllByStatus()
    {
        List list = this.footerService.getAllByStatus();
        return new ResponseEntity(list,HttpStatus.OK);
    }

    @GetMapping("/getFooterById/{footerId}")
    public ResponseEntity getById(@PathVariable("footerId") Integer footerId)
    {
        FooterMaster footerMaster = this.footerService.getById(footerId);
        return new ResponseEntity(footerMaster,HttpStatus.OK);
    }
}
