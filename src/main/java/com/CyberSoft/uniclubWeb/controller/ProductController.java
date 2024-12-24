package com.CyberSoft.uniclubWeb.controller;

import com.CyberSoft.uniclubWeb.dto.ProductDetailDto;
import com.CyberSoft.uniclubWeb.entity.ProductEntity;
import com.CyberSoft.uniclubWeb.payload.request.InsertProductRequest;
import com.CyberSoft.uniclubWeb.payload.resoponse.BaseResponse;
import com.CyberSoft.uniclubWeb.repository.ProductRepository;
import com.CyberSoft.uniclubWeb.service.imp.ProductServiceImp;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductServiceImp productServiceImp;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RedisTemplate redisTemplate;
    private Logger logger  = LoggerFactory.getLogger(ProductController.class);
    private Gson gson = new Gson();
    // insert product
    @PostMapping("/insert")
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
    // get all product to view all product
    @GetMapping("/all")
    public ResponseEntity<?> getAllProduct(){
//        redisTemplate.opsForValue().set("test", "Hello redis");
//        String test = (String) redisTemplate.opsForValue().get("test");
//        redisTemplate.hasKey()  Kiem tra co key hay ko.
//        System.out.println("Kiem tra redis: " + test);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(productServiceImp.getAllProduct());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
    // Get information to view Detail Product
    @GetMapping("/detail-add/{idProduct}")
    public ResponseEntity<?> getDetailAddToCart(@PathVariable int idProduct){
        BaseResponse baseResponse = new BaseResponse();
        List<ProductDetailDto> productDetailDtos = productServiceImp.getDetailProduct(idProduct);
        baseResponse.setMessage("Product Detail of " + productRepository.findById(idProduct).orElseThrow(() -> new RuntimeException("Not founc product with ID: " + idProduct)));
        baseResponse.setData(productDetailDtos);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
    @DeleteMapping("/show/{idProduct}")
    public ResponseEntity<?> deleteProduct(@PathVariable int idProduct)
    {
        BaseResponse baseResponse = new BaseResponse();
        boolean isDeleteSuccess = productServiceImp.isDeleteProduct(idProduct);
        baseResponse.setMessage(isDeleteSuccess ? "Product deleted successfully!" : "Product not deleted successfully!");
        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }

    @GetMapping("/find/{nameProduct}")
    public ResponseEntity<?> findProduct(@PathVariable String nameProduct)
    {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("Search results for" + nameProduct + ": ");
        baseResponse.setData(productServiceImp.findProduct(nameProduct));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<?> findProductSale()
    {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("All Product for Sale: ");
        baseResponse.setData(productServiceImp.findProductSale());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}