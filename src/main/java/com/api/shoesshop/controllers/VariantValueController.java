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

import com.api.shoesshop.entities.VariantValue;
import com.api.shoesshop.services.VariantValueService;
import com.api.shoesshop.types.FindAll;
import com.api.shoesshop.utils.Helper;

@Controller

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class VariantValueController {

        @Autowired
        private VariantValueService variantValueService;

        @GetMapping("/variant-value/read")
        public ResponseEntity<String> findAll(
                        @RequestParam Map<String, String> query) {
                Page<VariantValue> page = variantValueService.findAll(query);
                return Helper.responseSuccess(new FindAll<>(page.getContent(), page.getTotalElements()));
        }

        @GetMapping(value = "/variant-value/read/{id}")
        public ResponseEntity<String> findById(@PathVariable(name = "id") long id) {
                Optional<VariantValue> variantValue = variantValueService.findById(id);
                if (variantValue.isPresent()) {
                        return Helper.responseSuccess(variantValue.get());
                }
                return Helper.responseError();
        }

        @PostMapping(value = "/variant-value/create")
        public ResponseEntity<String> save(@RequestBody VariantValue body) {
                return Helper.responseCreated(variantValueService.save(body));
        }

        @PatchMapping(value = "/variant-value/update/{id}")
        public ResponseEntity<String> update(@RequestBody VariantValue body, @PathVariable(name = "id") long id) {
                return Helper.responseSuccess(variantValueService.update(body, id));
        }

        @DeleteMapping(value = "/variant-value/delete/{id}")
        public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
                variantValueService.delete(id);
                return Helper.responseSussessNoData();
        }
}
