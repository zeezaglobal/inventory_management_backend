package com.zeezaglobal.inventory_management_backend.Services;

import com.zeezaglobal.inventory_management_backend.Dto.JobCardRequest;
import com.zeezaglobal.inventory_management_backend.Entity.JobCard;
import com.zeezaglobal.inventory_management_backend.Entity.Product;
import com.zeezaglobal.inventory_management_backend.Entity.WorkOrder;
import com.zeezaglobal.inventory_management_backend.Repository.JobCardProductRepository;
import com.zeezaglobal.inventory_management_backend.Repository.JobCardRepository;
import com.zeezaglobal.inventory_management_backend.Repository.ProductRepository;
import com.zeezaglobal.inventory_management_backend.Repository.WorkOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public JobCard createJobCard(JobCardRequest jobCardRequest) {


        // Create a new JobCard
        JobCard jobCard = new JobCard();
        jobCard.setJobCardNumber(generateJobCardNumber());
        jobCard.setWorkOrder_id(jobCardRequest.getWorkOrderId());

        // Save the JobCard
        jobCard = jobCardRepository.save(jobCard);



        return jobCard;
    }

    public List<JobCard> getAllJobCards() {
        return jobCardRepository.findAll();
    }
}
