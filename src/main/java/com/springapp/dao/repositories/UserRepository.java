package com.springapp.dao.repositories;

import com.springapp.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {}
