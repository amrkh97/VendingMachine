package com.demo.vm.controller;

import com.demo.vm.model.MoneyModel;
import com.demo.vm.model.PaymentModel;
import com.demo.vm.model.ProductModel;
import com.demo.vm.service.ProductService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/product/all")
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @PostMapping(path = "/product")
    public ResponseEntity<ProductModel> addProduct(@RequestBody ProductModel model){
        return ResponseEntity.ok().body(productService.addProduct(model));
    }

    @PutMapping(path = "/product")
    public ResponseEntity<ProductModel> editProduct(@RequestBody ProductModel model){
        return ResponseEntity.ok().body(productService.editProduct(model));
    }

    @GetMapping(path = "/product/seller/{id}")
    public ResponseEntity<List<ProductModel>> findAllProductBySellerID(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.getAllByUserId(id));
    }

    @GetMapping(path = "/product/delete/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.deleteProductByID(id));
    }

    @PostMapping(path = "/buy")
    public ResponseEntity<Object> buyProducts(@RequestBody PaymentModel model) throws Exception {
        MoneyModel paymentModel = productService.buyProducts(model, model.getBuyerId());
        if(!Objects.isNull(paymentModel)){
            return ResponseEntity.ok().body(paymentModel);
        }else{
            JSONPObject jsonpObject = new JSONPObject("ErrorMessage",
                    "Error in processing your payment request");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonpObject);
        }
    }
}
