package com.manish.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manish.userservice.model.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity,Long> {
}