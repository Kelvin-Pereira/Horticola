package com.horticola.repository;

import com.horticola.entity.TipoVegetal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoVegetalRepository extends JpaRepository<TipoVegetal, Long> {
}
