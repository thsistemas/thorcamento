package com.thsistemas.orcamento.repositories;

import com.thsistemas.orcamento.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long>{
}
