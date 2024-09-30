package com.web_project.school.service.impl;

import com.web_project.school.model.ProductModel;
import com.web_project.school.repository.ProductRepository;
import com.web_project.school.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends GenericServiceImpl<ProductModel> implements ProductService {

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        super(productRepository);
    }
}