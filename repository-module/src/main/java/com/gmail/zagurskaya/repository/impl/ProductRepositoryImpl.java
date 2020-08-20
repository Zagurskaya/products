package com.gmail.zagurskaya.repository.impl;

import com.gmail.zagurskaya.repository.ProductRepository;
import com.gmail.zagurskaya.repository.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl extends GenericRepositoryImpl<Long, Product> implements ProductRepository {


}
