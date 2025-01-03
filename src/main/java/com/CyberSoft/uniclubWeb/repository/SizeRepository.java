package com.CyberSoft.uniclubWeb.repository;

import com.CyberSoft.uniclubWeb.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<SizeEntity, Integer> {
}
