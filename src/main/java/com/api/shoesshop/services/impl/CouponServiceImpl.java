package com.api.shoesshop.services.impl;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.api.shoesshop.entities.Coupon;
import com.api.shoesshop.repositories.CouponRepository;
import com.api.shoesshop.services.CouponService;
import com.api.shoesshop.utils.Helper;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public Coupon save(Coupon entity) {

        return couponRepository.save(entity);
    }

    @Override
    public Coupon update(long id, Coupon entity) {
        Coupon coupon = findById(id);
        if (coupon != null) {
            return couponRepository.save(entity);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        couponRepository.deleteById(id);
    }

    @Override
    public Page<Coupon> findAll(Map<String, String> query) {
        Page<Coupon> page = couponRepository.findAll(Helper.getPageable(query));
        return page;
    }

    @Override
    public Coupon findById(long id) {
        Optional<Coupon> optional = couponRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public Coupon check(String code) {
        Optional<Coupon> optional = couponRepository.findByCode(code);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
}
