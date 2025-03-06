package com.kaushik.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaushik.products.models.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String> {

}
