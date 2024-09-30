//package com.web_project.school.service;
//
//import com.web_project.school.model.ProductModel;
//import com.web_project.school.model.StudentModel;
//import com.web_project.school.repository.ProductRepository;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class InMemoryProductServiceImpl implements ProductService{
//    private final ProductRepository productRepository;
//
//    public InMemoryProductServiceImpl(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    @Override
//    public List<ProductModel> findAllProducts(){
//        return productRepository.findAll(Sort.by("id"));
//    }
//
//    @Override
//    public ProductModel findProductById(Long id) {
//        return productRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public ProductModel addProduct(ProductModel product){
//        return productRepository.save(product);
//    }
//
//    @Override
//    public ProductModel updateProduct(ProductModel product){
//        if (productRepository.existsById(product.getId())) {
//            return productRepository.save(product);
//        }
//        return null;
//    }
//
//    @Override
//    public void deleteProduct(Long id){
//        if (productRepository.existsById(id)) {
//            productRepository.deleteById(id);
//        }
//    }
//
//}
