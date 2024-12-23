package com.zplus.ZplusBackend.controller;

import com.zplus.ZplusBackend.dto.req.BannerRequestDto;
import com.zplus.ZplusBackend.dto.req.ConnectWithUsReqDto;

import com.zplus.ZplusBackend.dto.res.ConnectWithUsResDto;
import com.zplus.ZplusBackend.dto.res.MainResDto;
import com.zplus.ZplusBackend.model.BannerMaster;
import com.zplus.ZplusBackend.model.ConnectWithUsMaster;
import com.zplus.ZplusBackend.service.ConnectWithUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(name = "/ConnectWithUs")
@CrossOrigin(origins = "*")
//192.168.0.201
public class ConnectWithUsController {

    @Autowired
    private ConnectWithUsService connectWithUsService;

    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody ConnectWithUsReqDto connectWithUsReqDto)
    {
        Boolean flag = this.connectWithUsService.create(connectWithUsReqDto);
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
    public ResponseEntity update(@Valid @RequestBody ConnectWithUsReqDto connectWithUsReqDto)
    {
        try{
            Boolean flag = this.connectWithUsService.update(connectWithUsReqDto);
            return new ResponseEntity<>(flag,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{connectWithUsId}")
    public ResponseEntity getById(@PathVariable("connectWithUsId") Integer connectWithUsId)
    {
        try {
            ConnectWithUsResDto connectWithUsResDto = this.connectWithUsService.getById(connectWithUsId);
            return new ResponseEntity<>(connectWithUsResDto,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll()
    {
        try {
            List list = this.connectWithUsService.getAll();
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
            List list = this.connectWithUsService.getAllByStatus();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllBycarTPermitId/{carTPermitId}")
    public ResponseEntity getAllByCarTPermitId(@PathVariable("carTPermitId") Integer carTPermitId)
    {
        try {
            List<ConnectWithUsResDto> list = this.connectWithUsService.getAllByCarTPermitId(carTPermitId);
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
