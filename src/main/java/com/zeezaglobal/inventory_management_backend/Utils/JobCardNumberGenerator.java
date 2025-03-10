package com.zeezaglobal.inventory_management_backend.Utils;

import com.zeezaglobal.inventory_management_backend.Entity.JobCard;
import com.zeezaglobal.inventory_management_backend.Repository.JobCardRepository;
import com.zeezaglobal.inventory_management_backend.Services.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class JobCardNumberGenerator {

    @Autowired
    private CounterService counterService;



    public String generateJobCardNumber(String workOrderNumber) {
        // Fetch the current global counter value
        Long counter = counterService.incrementCounter();

        // Generate the job card number using the counter
        return "JC-" +  "-" + String.format("%05d", counter);
    }
}
