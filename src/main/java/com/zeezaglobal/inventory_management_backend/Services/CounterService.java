package com.zeezaglobal.inventory_management_backend.Services;

import com.zeezaglobal.inventory_management_backend.Entity.JobCardCounter;
import com.zeezaglobal.inventory_management_backend.Repository.CounterRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CounterService {

    @Autowired
    private CounterRepository counterRepository;

    private static final Long COUNTER_ID = 1L;
    @PostConstruct
    public void init() {
        counterRepository.findById(COUNTER_ID)
                .orElseGet(() -> {
                    // Initialize the counter if it doesn't exist
                    JobCardCounter counter = new JobCardCounter();
                    counter.setId(COUNTER_ID);
                    counter.setValue(0L);
                    counterRepository.save(counter);
                    return counter;
                });
    }
    // Get the current counter value, or initialize if not present
    public Long getCurrentCounterValue() {
        return counterRepository.findById(COUNTER_ID)
                .map(JobCardCounter::getValue)
                .orElseGet(() -> {
                    // Initialize the counter value if not found
                    JobCardCounter counter = new JobCardCounter();
                    counter.setId(COUNTER_ID);
                    counter.setValue(0L);
                    counterRepository.save(counter);
                    return 0L;
                });
    }

    // Increment the counter value
    public Long incrementCounter() {
        JobCardCounter counter = counterRepository.findById(COUNTER_ID)
                .orElseThrow(() -> new IllegalStateException("Counter not found"));
        counter.setValue(counter.getValue() + 1);
        counterRepository.save(counter);
        return counter.getValue();
    }
}