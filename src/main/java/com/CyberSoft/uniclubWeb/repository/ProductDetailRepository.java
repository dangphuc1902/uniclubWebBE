package com.CyberSoft.uniclubWeb.repository;

import com.CyberSoft.uniclubWeb.entity.ProductDetailEntity;
import com.CyberSoft.uniclubWeb.entity.key.ProductDetailID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, ProductDetailID> {
    List<ProductDetailEntity> findById_IdProduct(int idProduct);
}

