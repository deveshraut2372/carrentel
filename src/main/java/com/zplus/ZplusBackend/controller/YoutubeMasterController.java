package com.zplus.ZplusBackend.controller;

import com.zplus.ZplusBackend.dto.req.BannerRequestDto;
import com.zplus.ZplusBackend.dto.req.YoutubeMasterReq;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.BannerMaster;
import com.zplus.ZplusBackend.model.YoutubeMaster;
import com.zplus.ZplusBackend.service.YoutubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/youtube")
public class YoutubeMasterController {

    @Autowired
    private YoutubeService youtubeService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody YoutubeMasterReq youtubeMasterReq)
    {
        Boolean flag = this.youtubeService.create(youtubeMasterReq);
        MainResDto mainResDto=new MainResDto();
        if(Boolean.TRUE.equals(flag))
        {
            mainResDto.setFlag(flag);
            mainResDto.setMessage(" Create Succesfully");
            mainResDto.setResponseCode(HttpStatus.OK.value());
            return new ResponseEntity(flag, HttpStatus.OK);
        }else{
            mainResDto.setFlag(flag);
            mainResDto.setMessage(" Does Not  Created");
            mainResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity(flag,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody YoutubeMasterReq youtubeMasterReq)
    {
        try{
            Boolean flag = this.youtubeService.update(youtubeMasterReq);
            return new ResponseEntity<>(flag,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{youtubeId}")
    public ResponseEntity getById(@PathVariable("youtubeId") Integer youtubeId)
    {
        try {
            YoutubeMaster youtubeMaster = this.youtubeService.getById(youtubeId);
            return new ResponseEntity<>(youtubeMaster,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll()
    {
        try {
            List list = this.youtubeService.getAll();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllByStatus/{status}")
    public ResponseEntity getAllByStatus(@PathVariable("status") String status)
    {
        try {
            List list = this.youtubeService.getAllByStatus(status);
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
