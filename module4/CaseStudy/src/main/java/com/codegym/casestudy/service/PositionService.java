package com.codegym.casestudy.service;

import com.codegym.casestudy.entity.Position;

import javax.persistence.criteria.CriteriaBuilder;

public interface PositionService {
    Iterable<Position>findAll();

}
