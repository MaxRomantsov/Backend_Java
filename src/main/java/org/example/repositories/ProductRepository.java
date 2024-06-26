package org.example.repositories;

import org.example.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>, JpaSpecificationExecutor<ProductEntity> {

    @Query("SELECT p FROM ProductEntity p WHERE LOWER(p.name) LIKE LOWER(:keywordName) " +
            "AND LOWER(p.category.name) LIKE LOWER(:keywordCategory) " +
            "AND LOWER(p.description) LIKE LOWER(:keywordDescription)")
    Page<ProductEntity> searchProducts(
            @Param("keywordName") String keywordName,
            @Param("keywordCategory") String keywordCategory,
            @Param("keywordDescription") String keywordDescription,
            Pageable pageable);
}