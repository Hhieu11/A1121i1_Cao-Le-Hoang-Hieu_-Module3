package com.codegym.ung_dung_dien_thoai.service;

import com.codegym.ung_dung_dien_thoai.entity.Smartphone;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void remove(Long id);

    Smartphone findById1(Long id);
}
