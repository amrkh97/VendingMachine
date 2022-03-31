package com.demo.vm.repository;

import com.demo.vm.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductModel, Long> {
        List<ProductModel> findAllBySellerId(Long id);
}
