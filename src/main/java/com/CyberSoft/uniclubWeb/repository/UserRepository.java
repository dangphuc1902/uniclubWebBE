package com.CyberSoft.uniclubWeb.repository;

import com.CyberSoft.uniclubWeb.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.redis.core.RedisHash;

import java.util.Optional;

@Repository
  
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    //    Giá trị trả về 1 đối tượng vì email là duy nhất ko trùng.
    Optional<UserEntity> findByEmail(String username);
    boolean existsByEmail(String email);
}
