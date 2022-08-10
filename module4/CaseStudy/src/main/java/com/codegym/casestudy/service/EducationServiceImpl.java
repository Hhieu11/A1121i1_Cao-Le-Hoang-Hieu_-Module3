package com.codegym.casestudy.service;

import com.codegym.casestudy.entity.Education;
import com.codegym.casestudy.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    private EducationRepository educationRepository;
    @Override
    public Iterable<Education> findAll() {
        return educationRepository.findAll();
    }
}
