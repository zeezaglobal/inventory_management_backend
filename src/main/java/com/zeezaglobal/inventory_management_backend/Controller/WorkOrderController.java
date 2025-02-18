package com.zeezaglobal.inventory_management_backend.Controller;

import com.zeezaglobal.inventory_management_backend.Dto.WorkOrderRequest;
import com.zeezaglobal.inventory_management_backend.Entity.WorkOrder;
import com.zeezaglobal.inventory_management_backend.Services.WorkOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workorders")
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    public WorkOrderController(WorkOrderService workOrderService) {
        this.workOrderService = workOrderService;
    }

    @GetMapping
    public List<WorkOrder> getAllWorkOrders() {
        return workOrderService.getAllWorkOrders();
    }

    @GetMapping("/{id}")
    public WorkOrder getWorkOrderById(@PathVariable Long id) {
        return workOrderService.getWorkOrderById(id);
    }

    @PostMapping
    public WorkOrder createWorkOrder(@RequestBody WorkOrderRequest workOrder) {
        return workOrderService.createWorkOrder(workOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkOrder(@PathVariable Long id) {
        workOrderService.deleteWorkOrder(id);
    }
}
