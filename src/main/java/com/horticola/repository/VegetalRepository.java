package com.horticola.repository;

import com.horticola.entity.Vegetal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VegetalRepository extends JpaRepository<Vegetal, Long> {
}
