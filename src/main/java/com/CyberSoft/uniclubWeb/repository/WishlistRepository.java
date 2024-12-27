package com.CyberSoft.uniclubWeb.repository;

import com.CyberSoft.uniclubWeb.entity.WishlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<WishlistEntity,Integer> {
}
