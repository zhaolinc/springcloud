package com.lanqiao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 赵林
 * @date 2021/10/20 15:05
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer productNo;
    private String productName;
    private Double price;
}
