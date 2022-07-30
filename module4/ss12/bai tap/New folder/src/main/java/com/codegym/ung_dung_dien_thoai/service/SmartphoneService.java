package com.codegym.ung_dung_dien_thoai.service;

import com.codegym.ung_dung_dien_thoai.entity.Smartphone;
import com.codegym.ung_dung_dien_thoai.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SmartphoneService implements ISmartphoneService{
    @Autowired
    private ISmartphoneRepository smartPhoneRepository;
    @Override
    public Iterable<Smartphone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);

    }

    @Override
    public Smartphone findById1(Long id) {
        return smartPhoneRepository.findAllById1(id);
    }
}
