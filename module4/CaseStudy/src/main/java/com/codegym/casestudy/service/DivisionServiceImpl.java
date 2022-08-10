package com.codegym.casestudy.service;

import com.codegym.casestudy.entity.Division;
import com.codegym.casestudy.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionServiceImpl implements DivisionService{
    @Autowired
    private DivisionRepository divisionRepository;
    @Override
    public Iterable<Division> findAll() {
        return divisionRepository.findAll();
    }
}
