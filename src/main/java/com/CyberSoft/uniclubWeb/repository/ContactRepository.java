package com.CyberSoft.uniclubWeb.repository;

import com.CyberSoft.uniclubWeb.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {
}
