package com.example.user.controller;

import com.example.user.service.feign.ProductFeignService;
import com.lanqiao.model.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 赵林
 * @date 2021/10/20 15:11
 **/
@RestController
@Slf4j
public class UserController {
    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    ProductFeignService productFeignService;

    @GetMapping("/user/products")
    public List<ProductDTO> findProducts(){
        //方式一：RestTemplate
        //远程服务的url: http + 服务名（MICROSERVICE-GOODS） + 远程服务控制器path
        //List<ProductDTO> productDTOList = this.restTemplate.getForObject("http://microservice-goods/goods/products", List.class);

        //方式二：
        List<ProductDTO> productDTOList = this.productFeignService.findAllProducts();

        return productDTOList;
    }

    @GetMapping("/user/goods/findByProNo")
    public ProductDTO findByProductNo(@RequestParam("productNo") Integer productNo){
        log.debug("====>{}",productNo);
        return this.productFeignService.findByNo(productNo);
    }

    @PostMapping("/user/goods/save")
    public String saveProduct(@RequestBody ProductDTO productDTO){//@RequestBody 将提交的json数据转换成(ProductDTO)实体对象

        String res = this.productFeignService.save(productDTO);
        return res;
    }
}
