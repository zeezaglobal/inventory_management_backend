package com.zeezaglobal.inventory_management_backend.Repository;

import com.zeezaglobal.inventory_management_backend.Entity.WorkOrderProduct;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface WorkOrderProductRepository extends JpaRepository<WorkOrderProduct, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE WorkOrderProduct wop SET wop.status = ?2 WHERE wop.product.id = ?1")
    int setProductStatus(Long productId, int status);
}
