package com.zeezaglobal.inventory_management_backend.Services;

import com.zeezaglobal.inventory_management_backend.Entity.WorkOrder;
import com.zeezaglobal.inventory_management_backend.Repository.WorkOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkOrderService {

    private final WorkOrderRepository workOrderRepository;

    public WorkOrderService(WorkOrderRepository workOrderRepository) {
        this.workOrderRepository = workOrderRepository;
    }

    public List<WorkOrder> getAllWorkOrders() {
        return workOrderRepository.findAll();
    }

    public WorkOrder getWorkOrderById(Long id) {
        return workOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("WorkOrder not found"));
    }

    public WorkOrder createWorkOrder(WorkOrder workOrder) {
        return workOrderRepository.save(workOrder);
    }

    public void deleteWorkOrder(Long id) {
        workOrderRepository.deleteById(id);
    }
}

