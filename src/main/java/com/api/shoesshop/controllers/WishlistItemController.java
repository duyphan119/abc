package com.api.shoesshop.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.shoesshop.entities.WishlistItem;
import com.api.shoesshop.interceptors.AuthInterceptor;
import com.api.shoesshop.services.WishlistItemService;
import com.api.shoesshop.types.FindAll;
import com.api.shoesshop.utils.Helper;
import com.google.gson.Gson;

@Controller

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class WishlistItemController {

    @Autowired
    private WishlistItemService wishlistItemService;

    @GetMapping("/wishlist/account/read")
    public ResponseEntity<String> findByAccountId(HttpServletRequest req, @RequestParam Map<String, String> query) {
        if (AuthInterceptor.isLoggedin(req) == true) {
            long accountId = Long.parseLong(req.getAttribute("account_id").toString());
            Page<WishlistItem> page = wishlistItemService.findByAccountId(accountId, query);
            return Helper.responseSuccess(new FindAll<>(page.getContent(), page.getTotalElements()));
        }
        return Helper.responseUnauthorized();
    }

    @PostMapping("/wishlist/create")
    public ResponseEntity<String> save(HttpServletRequest req, @RequestBody WishlistItem body) {
        if (AuthInterceptor.isLoggedin(req) == true) {
            long accountId = Long.parseLong(req.getAttribute("account_id").toString());
            body.setAccountId(accountId);
            WishlistItem wishlistItem = wishlistItemService.save(body);
            if (wishlistItem != null) {
                return Helper.responseCreated(wishlistItem);
            }
        }
        return Helper.responseUnauthorized();

    }

    @DeleteMapping("/wishlist/delete/{id}")
    public ResponseEntity<String> save(HttpServletRequest req, @PathVariable long id) {
        if (AuthInterceptor.isLoggedin(req) == true) {
            wishlistItemService.delete(id);
            return Helper.responseSussessNoData();
        }
        return Helper.responseUnauthorized();
    }
}
