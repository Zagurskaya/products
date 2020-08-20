package com.gmail.zagurskaya.service;

import com.gmail.zagurskaya.service.model.ProductDTO;
import java.util.List;

public interface ProductService {

    List<ProductDTO> getProducts();

    void add(ProductDTO productDTO);

    void delete(Long id);

    void update(ProductDTO productDTO);

    void initializationBD();

}
