package com.product.controller;

import com.product.entities.Product;
import com.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@AllArgsConstructor
public class ProductController {

    ProductRepository repository;

    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product){
        return repository.save(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id){
        repository.deleteById(id);
    }

    @RequestMapping(value = "/product/{id}", method =  RequestMethod.PUT)
    public Product updateProduct(@PathVariable(value = "id") long id, @RequestBody Product newProduct) {
        Optional<Product> oldProduct = repository.findById(id);
        if (oldProduct.isPresent()) {
            Product product = oldProduct.get();
            product.setId(id);
            product.setName(newProduct.getName());
            product.setPreco(newProduct.getPreco());
            product.setDescription(newProduct.getDescription());
            return repository.save(product);
        }
        else
            return newProduct;
    }
}
