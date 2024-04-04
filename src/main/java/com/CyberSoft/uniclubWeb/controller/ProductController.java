package com.CyberSoft.uniclubWeb.controller;

import com.CyberSoft.uniclubWeb.payload.request.InsertProductRequest;
import com.CyberSoft.uniclubWeb.payload.resoponse.BaseResponse;
import com.CyberSoft.uniclubWeb.service.imp.ProductServiceImp;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductServiceImp productServiceImp;
    @Autowired
    private RedisTemplate redisTemplate;
    private Logger logger  = LoggerFactory.getLogger(ProductController.class);
    private Gson gson = new Gson();
    @PostMapping("")
    public ResponseEntity<?> insertProduct( InsertProductRequest insertProductRequest){
        String jsonRequest = gson.toJson(insertProductRequest);
        logger.info(jsonRequest);
        productServiceImp.insertProduct(insertProductRequest);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("OK");
        logger.info(gson.toJson(baseResponse));
        baseResponse.setData(productServiceImp.insertProduct(insertProductRequest));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<?> getALlProduct(){
        redisTemplate.opsForValue().set("test", "Hello redis");
        String test = (String) redisTemplate.opsForValue().get("test");
//        redisTemplate.hasKey()  Kiem tra co key hay ko.
        System.out.println("Kiem tra redis: " + test);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(productServiceImp.getAllProduct());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}