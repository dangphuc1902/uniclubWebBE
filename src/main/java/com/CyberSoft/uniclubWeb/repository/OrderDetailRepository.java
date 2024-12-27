package com.CyberSoft.uniclubWeb.repository;

import com.CyberSoft.uniclubWeb.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,Integer> {
}