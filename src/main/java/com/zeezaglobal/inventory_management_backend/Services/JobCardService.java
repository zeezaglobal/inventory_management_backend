package com.zeezaglobal.inventory_management_backend.Services;

import com.zeezaglobal.inventory_management_backend.Entity.JobCard;
import com.zeezaglobal.inventory_management_backend.Entity.Product;
import com.zeezaglobal.inventory_management_backend.Entity.WorkOrder;
import com.zeezaglobal.inventory_management_backend.Repository.JobCardRepository;
import com.zeezaglobal.inventory_management_backend.Repository.ProductRepository;
import com.zeezaglobal.inventory_management_backend.Repository.WorkOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class JobCardService {
    private final JobCardRepository jobCardRepository;
    private final WorkOrderRepository workOrderRepository;
    private final ProductRepository productRepository;

    public JobCardService(JobCardRepository jobCardRepository, WorkOrderRepository workOrderRepository, ProductRepository productRepository) {
        this.jobCardRepository = jobCardRepository;
        this.workOrderRepository = workOrderRepository;
        this.productRepository = productRepository;
    }

    public JobCard createJobCard(Long workOrderId, String jobCardNumber, Set<Long> productIds) {
        Optional<WorkOrder> workOrderOpt = workOrderRepository.findById(workOrderId);
        if (workOrderOpt.isEmpty()) {
            throw new RuntimeException("WorkOrder not found");
        }

        Set<Product> products = productRepository.findAllById(productIds).stream().collect(java.util.stream.Collectors.toSet());

        JobCard jobCard = new JobCard(jobCardNumber, workOrderOpt.get());
        jobCard.setProducts(products);
        return jobCardRepository.save(jobCard);
    }

    public List<JobCard> getAllJobCards() {
        return jobCardRepository.findAll();
    }
}
