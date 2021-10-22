package com.example.user.service.feign;

import com.lanqiao.model.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author 赵林
 * @date 2021/10/21 15:30
 **/
@FeignClient(value = "microservice-goods",fallback =ProductFeignServiceFallback.class )  //openfeign调用工具
public interface ProductFeignService {
    /**
     * 查询所有所有商品
     * @return
     */
    @GetMapping("/goods/products")
    List<ProductDTO> findAllProducts();

    @GetMapping("/goods/findNo/{productNo}")
    ProductDTO findByNo(@PathVariable Integer productNo);

    @PostMapping(value = "/goods/save",consumes = "application/json")
    String save(@RequestBody ProductDTO productDTO);
}
