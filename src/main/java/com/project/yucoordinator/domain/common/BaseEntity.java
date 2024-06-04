package com.project.yucoordinator.domain.common;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    @PrePersist
    public void onPrePersist() {
        this.createdTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updatedTime = LocalDateTime.now();
    }
}
