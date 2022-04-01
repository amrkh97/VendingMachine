package com.demo.vm.TestConfigurations;


import com.demo.vm.repository.UserRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import static org.mockito.Mockito.mock;

@Configuration
public class UserTestConfig {
    @Bean
    @Primary
    public UserRepo customUserRepo() {
        return mock(UserRepo.class);
    }
}
