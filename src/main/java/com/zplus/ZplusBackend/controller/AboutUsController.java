package com.zplus.ZplusBackend.controller;

import com.zplus.ZplusBackend.dto.req.AboutUsRequestDto;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.AboutUsMaster;
import com.zplus.ZplusBackend.service.impl.AboutUsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/about")
public class AboutUsController {

    @Autowired
    private AboutUsServiceImpl aboutUsService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody AboutUsRequestDto aboutUsRequestDto)
    {
        MainResDto mainResDto = this.aboutUsService.create(aboutUsRequestDto);
        return new ResponseEntity(mainResDto,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody AboutUsRequestDto aboutUsRequestDto)
    {
        System.out.println(aboutUsRequestDto.toString());
        Boolean flag = this.aboutUsService.update(aboutUsRequestDto);

        if(Boolean.TRUE.equals(flag)){
            return new ResponseEntity<>(flag,HttpStatus.OK);
        }else {
            return new ResponseEntity(flag,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{aboutUsId}")
    public ResponseEntity delete(@PathVariable("aboutUsId") Integer aboutUsId)
    {
        Boolean flag = this.aboutUsService.delete(aboutUsId);

        if(Boolean.TRUE.equals(flag)){
            return new ResponseEntity(flag,HttpStatus.OK);
        }else{
            return new ResponseEntity(flag,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{aboutUsId}")
    public ResponseEntity getById(@PathVariable("aboutUsId") Integer aboutUsId)
    {
        try{
            AboutUsMaster aboutUsMaster = this.aboutUsService.getById(aboutUsId);
            return new ResponseEntity<>(aboutUsMaster,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll()
    {
        try {
            List list = this.aboutUsService.getAll();
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
            List list = this.aboutUsService.getAllByStatus();
            return new ResponseEntity(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
