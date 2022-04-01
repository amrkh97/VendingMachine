package com.demo.vm.TestConfigurations;


import com.demo.vm.repository.ProductRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import static org.mockito.Mockito.mock;

@Configuration
public class ProductTestConfig {
    @Bean
    @Primary
    public ProductRepo customProductRepo(){return mock(ProductRepo.class);}
}