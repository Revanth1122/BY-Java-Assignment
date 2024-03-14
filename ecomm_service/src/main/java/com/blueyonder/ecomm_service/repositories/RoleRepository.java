package com.blueyonder.ecomm_service.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blueyonder.ecomm_service.entities.ERole;
import com.blueyonder.ecomm_service.entities.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
  Optional<Role> findByName(ERole name);
}