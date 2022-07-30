package com.codegym.ung_dung_dien_thoai.controller.RestController;

import com.codegym.ung_dung_dien_thoai.entity.Smartphone;
import com.codegym.ung_dung_dien_thoai.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@RequestMapping(value = "/smartphones", method = { RequestMethod.GET,RequestMethod.POST})
//@RequestMapping(value = "/smartphones")
        public class SmartPhoneRestController {
    @Autowired
    private ISmartphoneService smartphoneService;
    @PostMapping("/phone/create")
//    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }


    @GetMapping("/phone/list")
//    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }
    @GetMapping("/update/{id}")
    public ResponseEntity<Smartphone> update(@PathVariable Long id) {
        Smartphone smartphone = smartphoneService.findById1(id);
        return new ResponseEntity<>(smartphone, HttpStatus.OK);
    }

}
