package com.demo.vm.controller;

import com.demo.vm.model.ProductModel;
import com.demo.vm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
