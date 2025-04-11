package com.CyberSoft.uniclubWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.CyberSoft.uniclubWeb.service.imp.OrderServiceImp;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired 
    private OrderServiceImp orderServiceImp;

    // @GetMapping("/order-detail/{idProduct}")   
    // public ResponseEntity<?> getOrderDetail(@PathVariable int idProduct){
    //     BaseResponse baseResponse = new BaseResponse();
    //     baseResponse.setMessage("Order Detail for Product ID: " + idProduct);
    //     baseResponse.setData(orderServiceImp.getOrderDetail(idProduct));
    //     return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    // }
    // @PostMapping("/insert")
    // public ResponseEntity<?> postMethodName(@RequestBody String entity) {
    // 	BaseResponse baseResponse = new BaseResponse();
    // 	baseResponse.setData(baseResponse);
    // 	baseResponse.setMessage("");
        
    //     return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    // }
    
}
