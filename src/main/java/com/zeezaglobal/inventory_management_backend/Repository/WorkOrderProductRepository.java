package com.zeezaglobal.inventory_management_backend.Repository;

import com.zeezaglobal.inventory_management_backend.Entity.WorkOrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkOrderProductRepository extends JpaRepository<WorkOrderProduct, Long> {}
