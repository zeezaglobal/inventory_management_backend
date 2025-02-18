package com.zeezaglobal.inventory_management_backend.Dto;

public class ProductRequest {
    private String name;
    private Integer quantity;
    private String type;

    public ProductRequest(String name, Integer quantity, String type) {

        this.name = name;
        this.quantity = quantity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }
}