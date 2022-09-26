package com.api.shoesshop.controllers;

import java.io.File;
import java.util.Map;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.google.gson.Gson;

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
import org.springframework.web.multipart.MultipartFile;

import com.api.shoesshop.entities.Coupon;
import com.api.shoesshop.services.CouponService;
import com.api.shoesshop.types.FindAll;
import com.api.shoesshop.utils.Helper;

@Controller
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")

public class FileUploadController {

    public class UploadResponse {
        public String secure_url;
    }

    @PostMapping("/upload/image/single")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) {
        try {
            Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", "dwhjftwvw",
                    "api_key", "335652142568654",
                    "api_secret", "rVXHGRE29TukCR3eUxZEyJlv3ME"));
            Gson g = new Gson();
            String str = Helper.toJson(cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                    "public_id", "shoes shop/user_upload")));
            UploadResponse uploaded = g.fromJson(str, UploadResponse.class);
            return Helper.responseSuccess(uploaded.secure_url);
        } catch (Exception e) {
            System.out.println(e);
        }
        return Helper.responseSussessNoData();
    }

}
