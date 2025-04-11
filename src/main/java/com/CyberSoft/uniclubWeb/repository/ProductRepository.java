package com.CyberSoft.uniclubWeb.repository;

import com.CyberSoft.uniclubWeb.entity.ProductEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    @Query("SELECT p FROM ProductEntity p WHERE LOWER(p.productName) LIKE LOWER(CONCAT('%', :naneProduct, '%'))")
    List<ProductEntity> findByProductName(@Param("nameProduct") String naneProduct);
    List<ProductEntity> findByStatus(String status);
}
