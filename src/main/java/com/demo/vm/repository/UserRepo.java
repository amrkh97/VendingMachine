package com.demo.vm.repository;

import com.demo.vm.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {
    List<UserModel> findByRole(String userRole);
}
