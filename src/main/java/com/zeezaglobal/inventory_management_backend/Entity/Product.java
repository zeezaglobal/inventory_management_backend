package com.zeezaglobal.inventory_management_backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;  // Add this import
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "work_order_id")
    @JsonBackReference  // Add this annotation to prevent serialization of the back reference
    private WorkOrder workOrder;

    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    private Set<JobCard> jobCards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }

    public Set<JobCard> getJobCards() {
        return jobCards;
    }

    public void setJobCards(Set<JobCard> jobCards) {
        this.jobCards = jobCards;
    }
}
