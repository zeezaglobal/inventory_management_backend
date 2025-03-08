package com.zeezaglobal.inventory_management_backend.Entity;

import jakarta.persistence.*;

@Entity
public class JobCardCounter {
    @Id
    private Long id;

    private Long value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
