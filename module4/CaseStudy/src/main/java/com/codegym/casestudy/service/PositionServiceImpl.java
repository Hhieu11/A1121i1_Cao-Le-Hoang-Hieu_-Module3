package com.codegym.casestudy.service;

import com.codegym.casestudy.entity.Position;
import com.codegym.casestudy.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl  implements PositionService {
@Autowired
private PositionRepository positionRepository;
    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }
}
