package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="tbl_categories")
public class CategoryEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 200)
    private String image;

    @Column(length = 4000)
    private String description;

    @Column(name = "date_created")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date dateCreated;
    private LocalDateTime creationTime;

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;
}