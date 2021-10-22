package com.lanqiao.goods.controller;

import com.lanqiao.model.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 赵林
 * @date 2021/10/20 15:00
 **/
@RestController
@Slf4j
public class GoodsController {
    @Value("${server.port}")
    int port;

    @GetMapping("/goods/products")
    public List<ProductDTO> findAllProducts(){
        System.out.println("商品微服务的端口:"+port);
        ArrayList<ProductDTO> products = new ArrayList<>();
        products.add(new ProductDTO(1,"HuaWei mate40 pro",9999.0));
        products.add(new ProductDTO(2,"Iphone13 pro ",9999.0));
        return products;
    }

    @GetMapping("/goods/findNo/{productNo}")
    public ProductDTO findByNo(@PathVariable Integer productNo){
        log.debug("传过来的参数：{}"+productNo);
        return new ProductDTO(3,"Xiaomi11",9999.0);
    }

    @PostMapping(value = "/goods/save",consumes = "application/json")
    public String save(@RequestBody ProductDTO productDTO){
        System.out.println(productDTO.toString());
        return "success";
    }

}
