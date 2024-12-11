package com.zplus.ZplusBackend.controller;

import com.zplus.ZplusBackend.dto.req.ContactUsRequestDto;
import com.zplus.ZplusBackend.model.ContactUsMaster;
import com.zplus.ZplusBackend.service.impl.ContactUsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactUs")
@CrossOrigin(origins = "*")
public class ContactUsController {

    @Autowired
    private ContactUsServiceImpl contactUsService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody ContactUsRequestDto contactUsRequestDto)
    {
        Boolean flag = this.contactUsService.create(contactUsRequestDto);

        if(Boolean.TRUE.equals(flag)){
            return new ResponseEntity(flag, HttpStatus.OK);
        }else{
            return new ResponseEntity(flag,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody ContactUsRequestDto contactUsRequestDto)
    {
       try{
           Boolean flag = this.contactUsService.update(contactUsRequestDto);
           return new ResponseEntity<>(flag,HttpStatus.OK);
       }catch (Exception e){
           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity deleteContactUs(@PathVariable("contactId") Integer contactId)
    {
        Boolean flag = this.contactUsService.delete(contactId);

        if(Boolean.TRUE.equals(flag)){
            return new ResponseEntity(flag, HttpStatus.OK);
        }else {
            return new ResponseEntity(flag, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getContactUsById/{contactId}")
    public ResponseEntity getContactUsById(@PathVariable("contactId") Integer contactId)
    {
        ContactUsMaster contactUsMaster = this.contactUsService.getContactUsById(contactId);
        return new ResponseEntity(contactUsMaster,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll()
    {
        List list = this.contactUsService.getAll();
        return new ResponseEntity(list,HttpStatus.OK);
    }

    @GetMapping("/getCount")
    public ResponseEntity getCount()
    {
        long count = this.contactUsService.getCount();
        return new ResponseEntity<>(count,HttpStatus.OK);
    }
}
