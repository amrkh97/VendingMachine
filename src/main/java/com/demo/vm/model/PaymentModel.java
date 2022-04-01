package com.demo.vm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentModel {

    private Long buyerId;
    private Long productId;
    private Integer amount;
}
