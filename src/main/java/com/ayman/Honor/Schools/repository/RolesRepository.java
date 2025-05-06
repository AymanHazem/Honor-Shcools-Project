package com.ayman.Honor.Schools.repository;

import com.ayman.Honor.Schools.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer> {
    Roles getByRoleName(String roleName);
}
