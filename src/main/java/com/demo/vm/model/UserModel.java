package com.demo.vm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_MODEL")
public class UserModel{

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany
    @JoinColumn(name="role", referencedColumnName="ID")
    private List<RoleModel> role;

    @Column(name = "DEPOSIT")
    private Integer deposit = 0;

    @Column(name = "LATEST_DEPOSIT")
    private Integer latestDeposit = 0;


}
