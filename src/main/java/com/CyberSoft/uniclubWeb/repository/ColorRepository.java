package com.CyberSoft.uniclubWeb.repository;

import com.CyberSoft.uniclubWeb.entity.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<ColorEntity, Integer> {
}
