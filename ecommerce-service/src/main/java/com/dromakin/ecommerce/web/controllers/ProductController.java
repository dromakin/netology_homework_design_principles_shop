package com.dromakin.ecommerce.web.controllers;

import com.dromakin.ecommerce.entities.Product;
import com.dromakin.ecommerce.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@Slf4j
@Api(value = "Product Resource REST Endpoint")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("")
    public ResponseEntity<Product> create(
            @ApiParam(name = "Product", required = true)
            @Valid @RequestBody Product product
    ) {
        Product createdProduct = productService.saveProduct(product);

        if (createdProduct == null) {
            return ResponseEntity.notFound().build();

        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdProduct.getId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createdProduct);
        }
    }

    @PostMapping("/many")
    public ResponseEntity<List<Product>> create(
            @ApiParam(name = "List of products", required = true)
            @Valid @RequestBody List<Product> productList
    ) {
        List<Product> createdListProduct = productService.saveProducts(productList);

        if (createdListProduct == null) {
            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok(createdListProduct);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> read() {
        List<Product> productList = productService.fetchProducts();

        if (productList == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(productList);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Product>> readByName(
            @ApiParam(name = "Name of product", required = true)
            @PathVariable String name
    ) {
        List<Product> productList = productService.fetchProductsByName(name);

        if (productList == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(productList);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Product> readById(
            @ApiParam(name = "Id of product", required = true)
            @PathVariable Long id
    ) {
        Product product = productService.fetchProductById(id);

        if (product == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(product);
        }
    }


    @GetMapping("/manufacturer/{id}")
    public ResponseEntity<List<Product>> readByManufacturerId(
            @ApiParam(name = "Manufacturer product's id", required = true)
            @PathVariable Long id
    ) {
        List<Product> productList = productService.fetchProductsByManufacturerId(id);

        if (productList == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(productList);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @ApiParam(name = "Product", required = true)
            @RequestBody Product product,
            @ApiParam(name = "Product id", required = true)
            @PathVariable Long id
    ) {
        Product updatedProduct = productService.updateProduct(product, id);
        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedProduct);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @ApiParam(name = "Product id", required = true)
            @PathVariable Long id
    ) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


}
