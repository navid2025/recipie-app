package com.navid.recipieapp.repository;

import com.navid.recipieapp.domain.UnitOfMeasures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitOfMeasuresRepository extends JpaRepository<UnitOfMeasures, Long> {
    Optional<UnitOfMeasures> findByUom(String uom);

}