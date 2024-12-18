//package com.zplus.ZplusBackend.controller;
//
//
//import com.zplus.ZplusBackend.dto.req.CarTPointReq;
//import com.zplus.ZplusBackend.dto.req.SightsMasterReq;
//import com.zplus.ZplusBackend.dto.res.MainResDto;
//import com.zplus.ZplusBackend.model.SightMaster;
//import com.zplus.ZplusBackend.service.CartTPointService;
//import com.zplus.ZplusBackend.service.SightsMasterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins ="*")
//@RequestMapping("/CarTPoint")
//public class CartTPointController {
//
//
//    @Autowired
//    private CartTPointService cartTPointService;
//
//    @PostMapping("/create")
//    public ResponseEntity create(@RequestBody CarTPointReq carTPointReq)
//    {
//        Boolean flag = this.cartTPointService.create(carTPointReq);
//        MainResDto mainResDto=new MainResDto();
//        if(Boolean.TRUE.equals(flag))
//        {
//            mainResDto.setFlag(flag);
//            mainResDto.setMessage(" Created Succesfully");
//            mainResDto.setResponseCode(HttpStatus.OK.value());
//            return new ResponseEntity(flag, HttpStatus.OK);
//        }else{
//            mainResDto.setFlag(flag);
//            mainResDto.setMessage("  Does Not  Created");
//            mainResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
//            return new ResponseEntity(flag,HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity update(@RequestBody CarTPointReq carTPointReq)
//    {
//        try{
//            Boolean flag = this.cartTPointService.update(carTPointReq);
//            return new ResponseEntity<>(flag,HttpStatus.OK);
//        }catch (Exception e){
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/getById/{carTPointId}")
//    public ResponseEntity getById(@PathVariable("carTPointId") Integer carTPointId)
//    {
//        try {
//            SightMaster sightsMaster = this.cartTPointService.getById(carTPointId);
//            return new ResponseEntity<>(sightsMaster,HttpStatus.OK);
//        }catch (Exception e){
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping
//    public ResponseEntity getAll()
//    {
//        try {
//            List list = this.cartTPointService.getAll();
//            return new ResponseEntity<>(list,HttpStatus.OK);
//        }catch (Exception e){
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/getAllActiveSights")
//    public ResponseEntity getAllByStatus()
//    {
//        try {
//            List list = this.cartTPointService.getAllByStatus("Active");
//            return new ResponseEntity<>(list,HttpStatus.OK);
//        }catch (Exception e){
//            e.printStackTrace();
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//    }
//
////    @GetMapping("/getAllSightsBylocationId/{locationId}")
////    public ResponseEntity getAllSightsBylocationId(@PathVariable("locationId") Integer locationId)
////    {
////        try {
////            List list = this.sightsMasterService.getAllSightsBylocationId(locationId);
////            return new ResponseEntity<>(list,HttpStatus.OK);
////        }catch (Exception e){
////            e.printStackTrace();
////            return new ResponseEntity(HttpStatus.BAD_REQUEST);
////        }
////    }
//
//
//}
