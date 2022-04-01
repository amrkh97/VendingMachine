package com.demo.vm.service;

import com.demo.vm.model.MoneyModel;
import com.demo.vm.model.PaymentModel;
import com.demo.vm.model.ProductModel;
import com.demo.vm.model.UserModel;
import com.demo.vm.repository.ProductRepo;
import com.demo.vm.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    UserRepo userRepo;

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

    public MoneyModel buyProducts(PaymentModel model, Long buyerId) throws Exception {
        Long id = model.getProductId();
        if(productRepo.existsById(id)){
            ProductModel productModel = productRepo.findById(id).orElseThrow(Exception::new);
            if(userRepo.existsById(buyerId)){
               UserModel userModel =  userRepo.findById(buyerId).orElseThrow(Exception::new);
               Integer availableCredit = userModel.getDeposit();
               Integer productCost = model.getAmount() * productModel.getCost();
               if(availableCredit >= productCost && productModel.getAmountAvailable() >= model.getAmount()){
                   productModel.setAmountAvailable(productModel.getAmountAvailable() - model.getAmount());
                   Integer remainingAmount =  availableCredit - productCost;
                   userModel.setDeposit(remainingAmount);
                   userModel.setLatestDeposit(0);
                   MoneyModel moneyModel = returnChange(remainingAmount);
                   moneyModel.setUserId(buyerId);
                   productRepo.save(productModel);
                   return moneyModel;
               }else{
                   return null;
               }
            }
        }
        return null;
    }

    private MoneyModel returnChange(Integer changeAmount){
        MoneyModel returnedChange = new MoneyModel();
        if(changeAmount >0){
            int remainingMoney = changeAmount;
            int hundreds = changeAmount / 100;
            remainingMoney -= hundreds * 100;
            returnedChange.setHundredCoin(hundreds);
            int fifties = remainingMoney / 50;
            remainingMoney -= fifties * 50;
            returnedChange.setFiftyCoin(fifties);
            int twenties = remainingMoney / 100;
            remainingMoney -= twenties * 20;
            returnedChange.setTwentyCoin(twenties);
            int tens = remainingMoney / 10;
            remainingMoney -= tens * 10;
            returnedChange.setTenCoin(tens);
            Integer fives = remainingMoney / 5;
            returnedChange.setFiveCoin(fives);
            return returnedChange;
        }else{
            return null;
        }
    }
}
