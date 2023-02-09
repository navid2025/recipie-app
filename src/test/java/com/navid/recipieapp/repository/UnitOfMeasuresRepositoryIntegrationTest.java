package com.navid.recipieapp.repository;

import com.navid.recipieapp.domain.UnitOfMeasures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author n.zare 2/9/2023 $
 */

//integration test
@DataJpaTest
class UnitOfMeasuresRepositoryIntegrationTest {

   @Autowired
   UnitOfMeasuresRepository uintUnitOfMeasuresRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByUom() {
        Optional<UnitOfMeasures> uintUnitOfMeasures = uintUnitOfMeasuresRepository.findByUom("Cup");
        uintUnitOfMeasures.get().getUom();

        assertEquals(uintUnitOfMeasures.get().getUom(), "Cup");
    }
    @Test
    void findByUomSpoon() {
        Optional<UnitOfMeasures> uintUnitOfMeasures = uintUnitOfMeasuresRepository.findByUom("TeaSpoon");
        uintUnitOfMeasures.get().getUom();

        assertEquals(uintUnitOfMeasures.get().getUom(), "TeaSpoon");
    }
}