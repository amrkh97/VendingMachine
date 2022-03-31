package com.demo.vm.service;

import com.demo.vm.model.ProductModel;
import com.demo.vm.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<ProductModel> getAllProducts(){
        return productRepo.findAll();
    }

    public List<ProductModel> getAllByUserId(Long id){
        return productRepo.findAllBySellerId(id);
    }

    public ProductModel addProduct(ProductModel model){
        return productRepo.save(model);
    }

    public ProductModel editProduct(ProductModel model){
        return productRepo.save(model);
    }

    public Boolean deleteProductByID(Long id){
        if(productRepo.existsById(id)){
            productRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
