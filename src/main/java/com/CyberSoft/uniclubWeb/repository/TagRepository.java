package com.CyberSoft.uniclubWeb.repository;

import com.CyberSoft.uniclubWeb.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Integer> {
}
