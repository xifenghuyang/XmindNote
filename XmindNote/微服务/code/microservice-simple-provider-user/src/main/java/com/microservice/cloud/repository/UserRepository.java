package com.microservice.cloud.microservicesimpleprovideruser.repository;

import com.microservice.cloud.microservicesimpleprovideruser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
