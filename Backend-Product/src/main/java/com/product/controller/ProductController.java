package com.product.controller;

import com.product.entities.Product;
import com.product.repository.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProductController {

    ProductRepository repository;

    @ApiOperation(value = "return all products")
    @GetMapping("/product")
    public ResponseEntity getAllProducts(){
        try {
            return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
    @ApiOperation(value = "return product by id")
    @ApiResponses(
            @ApiResponse(code = 200, message = "")
    )
    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable Long id){
        try {
            return new ResponseEntity<>( repository.findById(id).get(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>( "ProductNotFound", HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @ApiOperation(value = "save new product")
    @ApiResponses(
            @ApiResponse(code = 200, message = "success")
    )
    @PostMapping("/product")
    public ResponseEntity saveProduct(@RequestBody Product product){
        try {
            repository.save(product);
            return new ResponseEntity<>( "success", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>( "error", HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @ApiOperation(value = "delete product by id")
    @ApiResponses(
            @ApiResponse(code = 200, message = "success")
    )
    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id){
        try {
            repository.deleteById(id);
            return new ResponseEntity<>( "success", HttpStatus.OK);
        }catch (Exception e ){
            return new ResponseEntity<>( "error", HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @ApiOperation(value = "edit product by id")
    @ApiResponses(
            @ApiResponse(code = 200, message = "success")
    )
    @PutMapping(value = "/product/{id}")
    public ResponseEntity updateProduct(@PathVariable(value = "id") long id, @RequestBody Product newProduct) {
        Optional<Product> oldProduct = repository.findById(id);
        try {
            if (oldProduct.isPresent()) {
                Product product = oldProduct.get();
                product.setId(id);
                product.setName(newProduct.getName());
                product.setPreco(newProduct.getPreco());
                product.setDescription(newProduct.getDescription());
                repository.save(product);
                return new ResponseEntity<>("success", HttpStatus.OK);
            }else {
                return new ResponseEntity<>("error", HttpStatus.METHOD_NOT_ALLOWED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("error-validation", HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
}