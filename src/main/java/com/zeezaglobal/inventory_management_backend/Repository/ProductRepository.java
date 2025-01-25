package com.zeezaglobal.inventory_management_backend.Repository;

import com.zeezaglobal.inventory_management_backend.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
