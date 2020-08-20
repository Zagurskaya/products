package com.gmail.zagurskaya.service.converter.impl;

import com.gmail.zagurskaya.repository.model.Product;
import com.gmail.zagurskaya.service.converter.ProductConverter;
import com.gmail.zagurskaya.service.model.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductConverterImpl implements ProductConverter {

    @Override
    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setLowerCaseName(product.getLowerCaseName());
        productDTO.setUpperCaseName(product.getUpperCaseName());
        productDTO.setCountLowerCaseName((long) product.getModelsLowerCaseList().size());
        productDTO.setCountUpperCaseName((long) product.getModelsUpperCaseList().size());
        return productDTO;
    }

    @Override
    public Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setLowerCaseName(productDTO.getLowerCaseName());
        product.setUpperCaseName(productDTO.getUpperCaseName());
        return product;
    }
}
