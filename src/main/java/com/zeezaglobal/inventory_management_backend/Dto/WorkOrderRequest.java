package com.zeezaglobal.inventory_management_backend.Dto;

import com.zeezaglobal.inventory_management_backend.Entity.Product;

import java.time.LocalDate;
import java.util.List;

public class WorkOrderRequest {
    private String workOrderNumber;
    private String clientAddress;

    private String status;

    private LocalDate dueDate;
    private LocalDate receivedDate;
    private List<ProductRequest> products;

    public String getClientAddress() {
        return clientAddress;
    }

    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }

    public List<ProductRequest> getProducts() {
        return products;
    }

    public void setProducts(List<ProductRequest> products) {
        this.products = products;
    }
}
