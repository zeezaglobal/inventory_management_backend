package com.zeezaglobal.inventory_management_backend.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class JobCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String jobCardNumber;

    @ManyToOne
    @JoinColumn(name = "work_order_id")
    private WorkOrder workOrder;

    @ManyToMany
    @JoinTable(
            name = "jobcard_product",
            joinColumns = @JoinColumn(name = "jobcard_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @JsonManagedReference
    private Set<Product> products;
    public JobCard(String jobCardNumber, WorkOrder workOrder) {
        this.jobCardNumber = jobCardNumber;
        this.workOrder = workOrder;
    }
    public JobCard() {
    }
    public JobCard(Long id, String jobCardNumber, WorkOrder workOrder, Set<Product> products) {
        this.id = id;
        this.jobCardNumber = jobCardNumber;
        this.workOrder = workOrder;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobCardNumber() {
        return jobCardNumber;
    }

    public void setJobCardNumber(String jobCardNumber) {
        this.jobCardNumber = jobCardNumber;
    }

    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
