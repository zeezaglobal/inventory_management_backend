package com.zeezaglobal.inventory_management_backend.Repository;

import com.zeezaglobal.inventory_management_backend.Entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {
}
