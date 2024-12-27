package com.CyberSoft.uniclubWeb.repository;

import com.CyberSoft.uniclubWeb.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardReponsitory extends JpaRepository<CardEntity, Integer> {
}
