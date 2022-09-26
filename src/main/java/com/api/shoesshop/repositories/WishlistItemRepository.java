package com.api.shoesshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.shoesshop.entities.WishlistItem;

public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {
    Page<WishlistItem> findByAccountId(long accountId, Pageable pageable);
}
