package com.zeezaglobal.inventory_management_backend.Services;

import com.zeezaglobal.inventory_management_backend.Dto.WorkOrderRequest;
import com.zeezaglobal.inventory_management_backend.Entity.Product;
import com.zeezaglobal.inventory_management_backend.Entity.WorkOrder;
import com.zeezaglobal.inventory_management_backend.Entity.WorkOrderProduct;
import com.zeezaglobal.inventory_management_backend.Repository.ProductRepository;
import com.zeezaglobal.inventory_management_backend.Repository.WorkOrderProductRepository;
import com.zeezaglobal.inventory_management_backend.Repository.WorkOrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkOrderService {

    private final WorkOrderRepository workOrderRepository;

    private final ProductRepository productRepository;
    private final WorkOrderProductRepository workOrderProductRepository;
    public WorkOrderService(
            WorkOrderRepository workOrderRepository,
            ProductRepository productRepository,
            WorkOrderProductRepository workOrderProductRepository) {
        this.workOrderRepository = workOrderRepository;
        this.productRepository = productRepository;
        this.workOrderProductRepository = workOrderProductRepository;
    }

    public List<WorkOrder> getAllWorkOrders() {
        return workOrderRepository.findAllWithProducts();
    }

    public WorkOrder getWorkOrderById(Long id) {
        return workOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("WorkOrder not found"));
    }
    @Transactional
    public WorkOrder createWorkOrder(WorkOrderRequest request) {
        // Create and save WorkOrder
        WorkOrder workOrder = new WorkOrder(request.getWorkOrderNumber(),
                request.getClientAddress(),
                request.getStatus(),
                request.getDueDate(),
                request.getReceivedDate());

        WorkOrder savedWorkOrder = workOrderRepository.save(workOrder);

        List<WorkOrderProduct> workOrderProducts = request.getProducts().stream().map(productRequest -> {
            Product product = new Product(productRequest.getName(),productRequest.getType()); // Assuming product is coming from request
            productRepository.save(product);
            // Set other fields of product if needed

            WorkOrderProduct workOrderProduct = new WorkOrderProduct();
            workOrderProduct.setWorkOrder(savedWorkOrder);
            workOrderProduct.setProduct(product);
            workOrderProduct.setQuantity(productRequest.getQuantity());
            return workOrderProduct;
        }).toList();

        workOrderProductRepository.saveAll(workOrderProducts);

        return savedWorkOrder;
    }

    public void deleteWorkOrder(Long id) {
        workOrderRepository.deleteById(id);
    }
}

