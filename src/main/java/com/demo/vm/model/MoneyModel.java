package com.demo.vm.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MoneyModel {

    private Long userId;
    private Integer fiveCoin = 0;
    private Integer tenCoin = 0;
    private Integer twentyCoin = 0;
    private Integer fiftyCoin = 0;
    private Integer hundredCoin = 0;

}
