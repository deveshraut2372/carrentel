package com.zplus.ZplusBackend.controller;

import com.zplus.ZplusBackend.dto.req.OurTeamRequestDto;
import com.zplus.ZplusBackend.model.OurTeamMaster;
import com.zplus.ZplusBackend.service.impl.OurTeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/ourTeam")
public class OurTeamController {

    @Autowired
    private OurTeamServiceImpl ourTeamService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody OurTeamRequestDto ourTeamRequestDto)
    {
        Boolean flag = this.ourTeamService.create(ourTeamRequestDto);

        if(Boolean.TRUE.equals(flag)){
            return new ResponseEntity<>(flag, HttpStatus.OK);
        }else{
            return new ResponseEntity(flag,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody OurTeamRequestDto ourTeamRequestDto)
    {
       try {
           Boolean flag = this.ourTeamService.update(ourTeamRequestDto);
           return new ResponseEntity<>(flag,HttpStatus.OK);
       }catch (Exception e){
           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }

    @DeleteMapping("/deleteTeam/{teamId}")
    public ResponseEntity delete(@PathVariable("teamId") Integer teamId)
    {
        try {
            this.ourTeamService.delete(teamId);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getOurTeamById/{teamId}")
    public ResponseEntity getOurTeamById(@PathVariable("teamId") Integer teamId)
    {
        try {
            OurTeamMaster ourTeamMaster = this.ourTeamService.findById(teamId);
            return new ResponseEntity<>(ourTeamMaster,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllTeam")
    public ResponseEntity getAllTeam()
    {
        try {
            List list = this.ourTeamService.getAllTeam();
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
            List list = this.ourTeamService.getAllByStatus();
            return new ResponseEntity(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
