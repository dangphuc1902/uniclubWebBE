package com.WorkStudySync.repository;

import java.util.Optional;
import java.util.UUID;

import com.WorkStudySync.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
	Optional<UserEntity> findByEmail(String username);
	boolean existsByEmail(String email);
}
