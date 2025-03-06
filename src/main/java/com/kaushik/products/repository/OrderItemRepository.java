package com.kaushik.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaushik.products.models.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, String> {

}
