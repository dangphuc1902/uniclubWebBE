package com.CyberSoft.uniclubWeb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CyberSoft.uniclubWeb.entity.OrderDetailEntity;
@Repository
public interface OrderReponsitory extends JpaRepository<OrderDetailEntity, Integer> {
}
