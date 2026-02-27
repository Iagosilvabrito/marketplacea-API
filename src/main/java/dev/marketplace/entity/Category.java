package dev.marketplace.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private boolean isActive;
    @Column(nullable = false)
    private LocalDateTime createdAt;

}
