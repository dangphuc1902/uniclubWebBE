package com.CyberSoft.uniclubWeb.repository;

import com.CyberSoft.uniclubWeb.entity.UsersEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity,Integer> {
//    Giá trị trả về 1 đối tượng vì email là duy nhất ko trùng.
UsersEntity findByEmail(String username);
}
