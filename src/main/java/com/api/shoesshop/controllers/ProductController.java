package com.api.shoesshop.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.shoesshop.entities.Product;
import com.api.shoesshop.services.ProductService;
import com.api.shoesshop.types.FindAll;
import com.api.shoesshop.utils.Helper;

@Controller

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product/read")
    public ResponseEntity<String> findAll(@RequestParam Map<String, String> query) {
        Page<Product> page = productService.findAll(query);
        return Helper.responseSuccess(new FindAll<>(page.getContent(), page.getTotalElements()));
    }

    @GetMapping(value = "/product/read/{id}")
    public ResponseEntity<String> findById(@PathVariable(name = "id") long id) {
        Optional<Product> Product = productService.findById(id);
        if (Product.isPresent()) {
            return Helper.responseSuccess(Product.get());
        }
        return Helper.responseError();
    }

    @PostMapping(value = "/product/create")
    public ResponseEntity<String> save(@RequestBody Product body) {
        return Helper.responseCreated(productService.save(body));
    }

    @PatchMapping(value = "/product/update/{id}")
    public ResponseEntity<String> update(@RequestBody Product body, @PathVariable(name = "id") long id) {
        return Helper.responseSuccess(productService.update(body, id));
    }

    @DeleteMapping(value = "/product/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
        productService.delete(id);
        return Helper.responseSussessNoData();
    }

}
