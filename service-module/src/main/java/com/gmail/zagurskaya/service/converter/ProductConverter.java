package com.gmail.zagurskaya.service.converter;

import com.gmail.zagurskaya.repository.model.Product;
import com.gmail.zagurskaya.service.model.ProductDTO;

public interface ProductConverter {

    ProductDTO toDTO(Product product);

    Product toEntity(ProductDTO productDTO);

}
