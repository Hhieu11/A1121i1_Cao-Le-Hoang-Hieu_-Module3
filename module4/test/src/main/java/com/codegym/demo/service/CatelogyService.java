package com.codegym.demo.service;

import com.codegym.demo.entity.Catelogy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatelogyService {
    List<Catelogy>findAll();
}
