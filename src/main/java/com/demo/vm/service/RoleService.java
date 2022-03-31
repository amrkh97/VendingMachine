package com.demo.vm.service;

import com.demo.vm.model.RoleModel;
import com.demo.vm.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public List<RoleModel> getAllRoles(){
        return roleRepo.findAll();
    }

    public RoleModel addRole(RoleModel model){
        return roleRepo.save(model);
    }

    public RoleModel editRole(RoleModel model){
        return roleRepo.save(model);
    }

    public Boolean deleteRoleById(Long id){
        if(roleRepo.existsById(id)){
            roleRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
