package com.thsistemas.orcamento.repositories;

import com.thsistemas.orcamento.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long>{
}
