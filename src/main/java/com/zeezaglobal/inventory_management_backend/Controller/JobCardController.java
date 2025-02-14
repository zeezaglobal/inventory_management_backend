package com.zeezaglobal.inventory_management_backend.Controller;

import com.zeezaglobal.inventory_management_backend.Dto.JobCardRequest;
import com.zeezaglobal.inventory_management_backend.Entity.JobCard;
import com.zeezaglobal.inventory_management_backend.Services.JobCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/jobcards")
public class JobCardController {

    private final JobCardService jobCardService;

    public JobCardController(JobCardService jobCardService) {
        this.jobCardService = jobCardService;
    }

    @PostMapping
    public JobCard createJobCard(@RequestBody JobCardRequest request) {
        return jobCardService.createJobCard(request.getWorkOrderId(), request.getJobCardNumber(), request.getProductIds());
    }

    @GetMapping
    public List<JobCard> getAllJobCards() {
        return jobCardService.getAllJobCards();
    }
}