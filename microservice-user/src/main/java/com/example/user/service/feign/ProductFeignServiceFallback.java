package com.example.user.service.feign;

import com.lanqiao.model.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 回退逻辑实现
 * @author 赵林
 * @date 2021/10/22 10:20
 **/
@Component
public class ProductFeignServiceFallback implements ProductFeignService{
    @Override
    public List<ProductDTO> findAllProducts() {
        System.out.println("ProductFeignServiceFallback");
        ArrayList<ProductDTO> unkonwList = new ArrayList<>();
        unkonwList.add(new ProductDTO(-9999,"未知商品",0.0));
        return unkonwList;
    }

    @Override
    public ProductDTO findByNo(Integer productNo) {
        return new ProductDTO(-9999,"未知商品",0.0);
    }

    @Override
    public String save(ProductDTO productDTO) {
        return "保存失败";
    }

}
