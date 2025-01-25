package com.zeezaglobal.inventory_management_backend.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "WorkOrder")
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String workOrderNumber;

    private LocalDate dueDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workOrder")
    private List<Product> products;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}