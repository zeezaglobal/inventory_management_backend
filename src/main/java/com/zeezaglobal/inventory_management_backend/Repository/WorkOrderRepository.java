package com.zeezaglobal.inventory_management_backend.Repository;

import com.zeezaglobal.inventory_management_backend.Entity.WorkOrder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {
    @Query("SELECT w FROM WorkOrder w LEFT JOIN FETCH w.workOrderProducts wp LEFT JOIN FETCH wp.product")
    List<WorkOrder> findAllWithProducts();
    @Modifying
    @Transactional
    @Query("UPDATE WorkOrder w SET w.status = ?2 WHERE w.id = ?1")
    void updateStatus(Long workOrderId, String newStatus);
}
