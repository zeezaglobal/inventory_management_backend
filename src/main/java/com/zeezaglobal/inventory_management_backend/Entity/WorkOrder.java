package com.zeezaglobal.inventory_management_backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;  // Add this import
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "WorkOrder")

public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String workOrderNumber;

    private String clientAddress;

    private String status;

    private LocalDate dueDate;
    private LocalDate receivedDate;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "workOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<WorkOrderProduct> workOrderProducts;


    @OneToMany(mappedBy = "workOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<JobCard> jobCards;
    // Getters and Setters


    public WorkOrder() {
    }

    public WorkOrder(String workOrderNumber, String clientAddress, String status, LocalDate dueDate, LocalDate receivedDate) {
        this.workOrderNumber = workOrderNumber;
        this.clientAddress = clientAddress;
        this.status = status;
        this.dueDate = dueDate;
        this.receivedDate = receivedDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<WorkOrderProduct> getWorkOrderProducts() {
        return workOrderProducts;
    }

    public void setWorkOrderProducts(List<WorkOrderProduct> workOrderProducts) {
        this.workOrderProducts = workOrderProducts;
    }

    public void setJobCards(List<JobCard> jobCards) {
        this.jobCards = jobCards;
    }

    public Long getId() {
        return id;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReceivedDate() {
        return receivedDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<JobCard> getJobCards() {
        return jobCards;
    }
}
