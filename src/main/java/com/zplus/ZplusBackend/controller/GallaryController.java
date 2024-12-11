package com.zplus.ZplusBackend.controller;

import com.zplus.ZplusBackend.dto.req.GallaryRequestDto;
import com.zplus.ZplusBackend.model.GallaryMaster;
import com.zplus.ZplusBackend.service.impl.GallaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/gallary")
public class GallaryController {
    @Autowired
    private GallaryServiceImpl  gallaryServiceservice;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody GallaryRequestDto gallaryRequestDto)
    {
//        System.out.println(gallaryRequestDto.toString());
        Boolean flag = this.gallaryServiceservice.create(gallaryRequestDto);

        if(Boolean.TRUE.equals(flag)){
            return new ResponseEntity<>(flag, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(flag,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody GallaryRequestDto gallaryRequestDto)
    {
      try {
           Boolean flag= this.gallaryServiceservice.update(gallaryRequestDto);
           return new ResponseEntity<>(flag,HttpStatus.OK);
      }catch (Exception e){
          e.printStackTrace();
          return new ResponseEntity(HttpStatus.BAD_REQUEST);
      }
    }

    @DeleteMapping("/delete/{gallaryId}")
    public ResponseEntity delete(@PathVariable("gallaryId")Integer gallaryId)
    {
        Boolean flag = this.gallaryServiceservice.delete(gallaryId);

        if(Boolean.TRUE.equals(flag)){
            return new ResponseEntity(flag,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(flag,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getGallaryById/{gallaryId}")
    public ResponseEntity getGallaryById(@PathVariable("gallaryId") Integer gallaryId)
    {
        GallaryMaster gallaryMaster = this.gallaryServiceservice.getGallaryById(gallaryId);
        return new ResponseEntity<>(gallaryMaster,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll()
    {
        List list = this.gallaryServiceservice.getAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/getAllStatus")
    public ResponseEntity getAllByStatus()
    {
        List list = this.gallaryServiceservice.getAllByStatus();
        return new ResponseEntity(list,HttpStatus.OK);
    }
}
