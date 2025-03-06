package com.kaushik.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaushik.products.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

}
