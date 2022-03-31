package com.demo.vm.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ITEM_MODEL")
public class ProductModel {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "AMOUNT_AVAILABLE")
    private Integer amountAvailable;

    @Column(name = "COST")
    private Integer cost;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @ManyToOne
    @JoinColumn(name="POSTED_BY", referencedColumnName="id")
    private UserModel seller;
}
