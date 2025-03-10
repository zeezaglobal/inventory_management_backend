package com.zeezaglobal.inventory_management_backend.Controller;

import com.zeezaglobal.inventory_management_backend.Dto.JobCardRequest;
import com.zeezaglobal.inventory_management_backend.Entity.JobCard;
import com.zeezaglobal.inventory_management_backend.Services.JobCardService;
import org.springframework.http.ResponseEntity;
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
    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateJobCardStatus(@PathVariable Long id, @RequestParam int status) {
        boolean updated = jobCardService.updateJobCardStatus(id, status);
        if (updated) {
            return ResponseEntity.ok("JobCard status updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public JobCard createJobCard(@RequestBody JobCardRequest request) {
        return jobCardService.createJobCard(request);
    }

    @GetMapping
    public List<JobCard> getAllJobCards() {
        return jobCardService.getAllJobCards();
    }
}