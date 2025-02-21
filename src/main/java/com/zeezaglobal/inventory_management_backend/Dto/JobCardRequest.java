package com.zeezaglobal.inventory_management_backend.Dto;

import java.util.Set;

public class JobCardRequest {
    private Long workOrderId;
    private Set<ProductQuantity> productIds;

    public JobCardRequest() {
    }

    public JobCardRequest(Long workOrderId, Set<ProductQuantity> productIds) {
        this.workOrderId = workOrderId;
        this.productIds = productIds;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public Set<ProductQuantity> getProductIds() {
        return productIds;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public void setProductIds(Set<ProductQuantity> productIds) {
        this.productIds = productIds;
    }

    public static class ProductQuantity {
        private Long id;
        private int quantity;

        public ProductQuantity() {
        }

        public ProductQuantity(Long id, int quantity) {
            this.id = id;
            this.quantity = quantity;
        }

        public Long getId() {
            return id;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
