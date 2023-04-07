package com.dromakin.ecommerce.services;

import com.dromakin.ecommerce.entities.Product;
import com.dromakin.ecommerce.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> saveProducts(List<Product> productList) {
        return productRepository.save(productList);
    }

    @Override
    public List<Product> fetchProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> fetchProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> fetchProductsByManufacturerId(Long id) {
        return productRepository.findByManufacturer(id);
    }

    @Override
    public Product fetchProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        Product prDb = productRepository.findOne(id);

        if (Objects.nonNull(product.getName())
                && !"".equalsIgnoreCase(product.getName())) {
            prDb.setName(product.getName());
        }

        if (Objects.nonNull(product.getDescription())
                && !"".equalsIgnoreCase(product.getDescription())) {
            prDb.setDescription(product.getDescription());
        }

        if (Objects.nonNull(product.getPrice())) {
            prDb.setPrice(product.getPrice());
        }

        return productRepository.save(prDb);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.delete(id);
    }
}
