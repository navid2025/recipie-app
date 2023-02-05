package com.navid.recipieapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @author n.zare 2/5/2023 $
 */
@Entity
public class UnitOfMeasures {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String uom;
}
