package com.CyberSoft.uniclubWeb.repository;

import com.CyberSoft.uniclubWeb.entity.ProductDetailEntity;
import com.CyberSoft.uniclubWeb.entity.ProductEntity;
import com.CyberSoft.uniclubWeb.entity.key.ProductDetailID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
// ProductDetailID: Do nhiều  khoá chính trong cùng 1 bảng nên  để  đối tuong
public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, ProductDetailID> {
}
