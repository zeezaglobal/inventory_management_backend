package com.zeezaglobal.inventory_management_backend.Services;

import com.zeezaglobal.inventory_management_backend.Dto.JobCardRequest;
import com.zeezaglobal.inventory_management_backend.Entity.JobCard;
import com.zeezaglobal.inventory_management_backend.Entity.JobCardProduct;
import com.zeezaglobal.inventory_management_backend.Entity.Product;
import com.zeezaglobal.inventory_management_backend.Entity.WorkOrder;
import com.zeezaglobal.inventory_management_backend.Repository.JobCardProductRepository;
import com.zeezaglobal.inventory_management_backend.Repository.JobCardRepository;
import com.zeezaglobal.inventory_management_backend.Repository.ProductRepository;
import com.zeezaglobal.inventory_management_backend.Repository.WorkOrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.zeezaglobal.inventory_management_backend.Utils.JobCardNumberGenerator.generateJobCardNumber;

@Service
public class JobCardService {
    private final JobCardRepository jobCardRepository;
    private final WorkOrderRepository workOrderRepository;
    private final ProductRepository productRepository;
    private final JobCardProductRepository jobCardProductRepository;

    public JobCardService(JobCardRepository jobCardRepository, WorkOrderRepository workOrderRepository, ProductRepository productRepository, JobCardProductRepository jobCardProductRepository) {
        this.jobCardRepository = jobCardRepository;
        this.workOrderRepository = workOrderRepository;
        this.productRepository = productRepository;
        this.jobCardProductRepository = jobCardProductRepository;
    }

    @Transactional
    public JobCard createJobCard(JobCardRequest jobCardRequest) {
        // Fetch the WorkOrder
        WorkOrder workOrder = workOrderRepository.findById(jobCardRequest.getWorkOrderId())
                .orElseThrow(() -> new RuntimeException("WorkOrder not found"));

        // Create a new JobCard
        JobCard jobCard = new JobCard();
        jobCard.setJobCardNumber(generateJobCardNumber());
        jobCard.setWorkOrder(workOrder);

        // Save JobCard first to generate an ID
        jobCard = jobCardRepository.save(jobCard);

        // Fetch Products and create JobCardProduct entries
        JobCard finalJobCard = jobCard;
        Set<JobCardProduct> jobCardProducts = jobCardRequest.getProductIds().stream()
                .map(productId -> {
                    Product product = productRepository.findById(productId)
                            .orElseThrow(() -> new RuntimeException("Product not found"));
                    JobCardProduct jobCardProduct = new JobCardProduct();
                    jobCardProduct.setJobCard(finalJobCard);
                    jobCardProduct.setProduct(product);
                    return jobCardProduct;
                })
                .collect(Collectors.toSet());

        // Save all JobCardProducts
        jobCardProductRepository.saveAll(jobCardProducts);

        jobCard.setJobCardProducts(jobCardProducts);


        return jobCard;
    }

    public List<JobCard> getAllJobCards() {
        return jobCardRepository.findAll();
    }
}
