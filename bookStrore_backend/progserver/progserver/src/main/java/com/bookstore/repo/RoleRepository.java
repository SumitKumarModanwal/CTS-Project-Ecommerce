package com.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
