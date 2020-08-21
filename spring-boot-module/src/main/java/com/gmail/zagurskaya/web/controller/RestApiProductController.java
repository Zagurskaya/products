package com.gmail.zagurskaya.web.controller;

import com.gmail.zagurskaya.service.ProductService;
import com.gmail.zagurskaya.service.model.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.gmail.zagurskaya.web.constant.URLConstant.URL_PRODUCT;
import static com.gmail.zagurskaya.web.constant.URLConstant.URL_REST_API;
import static com.gmail.zagurskaya.web.constant.URLConstant.URL_REST_INIT;

@RestController
@RequestMapping(URL_REST_API)
public class RestApiProductController {

    private static final Logger logger = LoggerFactory.getLogger(RestApiProductController.class);

    private final ProductService productService;

    @Autowired
    public RestApiProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(
            value = URL_PRODUCT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<ProductDTO> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping(URL_REST_INIT)
    public ResponseEntity<List<ProductDTO>> init() {
        productService.initializationBD();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
