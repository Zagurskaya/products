package com.gmail.zagurskaya.service.impl;

import com.gmail.zagurskaya.repository.ProductRepository;
import com.gmail.zagurskaya.repository.ModelRepository;
import com.gmail.zagurskaya.repository.model.Model;
import com.gmail.zagurskaya.repository.model.Product;
import com.gmail.zagurskaya.service.ProductService;
import com.gmail.zagurskaya.service.converter.ProductConverter;
import com.gmail.zagurskaya.service.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductConverter productConverter;
    private final ProductRepository productRepository;
    private final ModelRepository modelRepository;

    @Autowired
    public ProductServiceImpl(ProductConverter productConverter, ProductRepository productRepository, ModelRepository modelRepository) {
        this.productConverter = productConverter;
        this.productRepository = productRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    @Transactional
    public List<ProductDTO> getProducts() {
        List<Product> product = productRepository.findAll(0, Integer.MAX_VALUE);
        List<ProductDTO> dtos = product.stream()
                .map(productConverter::toDTO)
                .collect(Collectors.toList());
        return dtos;
    }

    @Override
    @Transactional
    public void add(ProductDTO productDTO) {
        Product product = productConverter.toEntity(productDTO);
        productRepository.persist(product);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Product product = productRepository.findById(id);
        productRepository.remove(product);
    }

    @Override
    @Transactional
    public void update(ProductDTO productDTO) {
        Product product = productConverter.toEntity(productDTO);
        productRepository.merge(product);
    }

    @Override
    @Transactional
    public void initializationBD() {
        if (productRepository.findAll().isEmpty()) {
            Set<String> keyList = new HashSet<>();
            List<Model> fullProductList = modelRepository.findAll();
            fullProductList.stream().forEach(products -> keyList.add(products.getName().toLowerCase()));

            keyList.stream().forEach(s -> {
                Product product = new Product();
                product.setName(s);
                String wordWithUpperCaseFirstSymbol = s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
                product.setUpperCaseName(wordWithUpperCaseFirstSymbol);
                String wordWithLowerCaseFirstSymbol = s.substring(0, 1).toLowerCase() + s.substring(1, s.length());
                product.setLowerCaseName(wordWithLowerCaseFirstSymbol);
                productRepository.persist(product);
            });
        }
    }
}
