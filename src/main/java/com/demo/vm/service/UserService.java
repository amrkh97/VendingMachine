package com.demo.vm.service;

import com.demo.vm.model.MoneyModel;
import com.demo.vm.model.UserModel;
import com.demo.vm.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<UserModel> getUserRole(String userRole){
        return userRepo.findByRole(userRole);
    }

    public List<UserModel> getAll(){
        return userRepo.findAll();
    }


    public UserModel addUser(UserModel user){
        return userRepo.save(user);
    }

    public UserModel editUser(UserModel user){

        return userRepo.save(user);
    }

    public Boolean deleteUser(Long id) {
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public UserModel depositMoney(MoneyModel model) throws Exception {
        Integer total = 0;
        total += model.getFiveCoin() * 5;
        total += model.getTenCoin() * 10;
        total += model.getTwentyCoin() * 20;
        total += model.getFiftyCoin() * 50;
        total += model.getHundredCoin() * 100;
        Long userId = model.getUserId();
        if(userRepo.existsById(userId)){
            UserModel userModel = userRepo.findById(userId).orElseThrow(Exception::new);
            userModel.setDeposit(userModel.getDeposit()+total);
            userModel.setLatestDeposit(total);
            userRepo.save(userModel);
            return userModel;
        }else{
            return null;
        }
    }

    public String resetDeposit(Long id) throws Exception{
        if(userRepo.existsById(id)){
            UserModel userModel = userRepo.findById(id).orElseThrow(Exception::new);
            Integer lastDeposit = userModel.getLatestDeposit();
            userModel.setDeposit(userModel.getDeposit()-lastDeposit);
            userModel.setLatestDeposit(0);
            userRepo.save(userModel);
            return "Deposit has been reset";
        } else{
            return "User Not Found";
        }
    }
}
