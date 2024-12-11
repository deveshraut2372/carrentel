package com.zplus.ZplusBackend.controller;

import com.zplus.ZplusBackend.dto.req.MenuRequestDto;
import com.zplus.ZplusBackend.model.MenuMaster;
import com.zplus.ZplusBackend.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuServiceImpl menuService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody MenuRequestDto menuRequestDto)
    {
        Boolean flag = this.menuService.create(menuRequestDto);

        if(Boolean.TRUE.equals(flag)){
            return new ResponseEntity<>(flag, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(flag,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody MenuRequestDto menuRequestDto)
    {
        try {
            Boolean flag = this.menuService.update(menuRequestDto);
            return new ResponseEntity<>(flag,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{menuId}")
    public ResponseEntity deleteMenu(@PathVariable("menuId") Integer menuId)
    {
        Boolean flag = this.menuService.delete(menuId);

        if(Boolean.TRUE.equals(flag)){
            return new ResponseEntity(flag,HttpStatus.OK);
        }else{
            return new ResponseEntity(flag,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getMenu/{menuId}")
    public ResponseEntity getMenu(@PathVariable("menuId") Integer menuId)
    {
        try {
            MenuMaster menuMaster =this.menuService.findMenu(menuId);
            return new ResponseEntity<>(menuMaster,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll()
    {
        try {
            List list = this.menuService.getAll();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllByStatus")
    public ResponseEntity getAllByStatus(){
        try {
            List list = this.menuService.getAllByStatus();
            return new ResponseEntity(list,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
