package com.zeezaglobal.inventory_management_backend.Dto;

import java.util.Set;

public class JobCardRequest {
    private Long workOrderId;

    private Set<Long> productIds;

    public JobCardRequest() {
    }

    public JobCardRequest(Long workOrderId, Set<Long> productIds) {
        this.workOrderId = workOrderId;
        this.productIds = productIds;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public Set<Long> getProductIds() {
        return productIds;
    }
}
