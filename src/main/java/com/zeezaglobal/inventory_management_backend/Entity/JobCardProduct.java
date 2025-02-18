package com.zeezaglobal.inventory_management_backend.Entity;

import jakarta.persistence.*;

@Entity
public class JobCardProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jobcard_id", nullable = false)
    private JobCard jobCard;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int quantity;
}
