package com.api.shoesshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.shoesshop.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
