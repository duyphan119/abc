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

import com.api.shoesshop.entities.Variant;
import com.api.shoesshop.services.VariantService;
import com.api.shoesshop.types.FindAll;
import com.api.shoesshop.utils.Helper;

@Controller

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class VariantController {

    @Autowired
    private VariantService variantService;

    @GetMapping(value = "/variant/read")
    public ResponseEntity<String> findAll(@RequestParam Map<String, String> query) {
        Page<Variant> page = variantService.findAll(query);
        return Helper.responseSuccess(new FindAll<>(page.getContent(), page.getTotalElements()));
    }

    @GetMapping(value = "/variant/read/{id}")
    public ResponseEntity<String> findById(@PathVariable(name = "id") long id) {
        Optional<Variant> variant = variantService.findById(id);
        if (variant.isPresent()) {
            return Helper.responseSuccess(variant.get());
        }
        return Helper.responseError();
    }

    @PostMapping(value = "/variant/create")
    public ResponseEntity<String> save(@RequestBody Variant body) {
        return Helper.responseCreated(variantService.save(body));
    }

    @PatchMapping(value = "/variant/update/{id}")
    public ResponseEntity<String> update(@RequestBody Variant body, @PathVariable(name = "id") long id) {
        return Helper.responseSuccess(variantService.update(body, id));
    }

    @DeleteMapping(value = "/variant/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
        variantService.delete(id);
        return Helper.responseSussessNoData();
    }

}
