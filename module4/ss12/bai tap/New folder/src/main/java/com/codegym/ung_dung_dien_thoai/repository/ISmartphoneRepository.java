package com.codegym.ung_dung_dien_thoai.repository;

import com.codegym.ung_dung_dien_thoai.entity.Smartphone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends CrudRepository<Smartphone,Long> {
    @Query(value="select *from smartphones where id=?1",nativeQuery=true)
    Smartphone findAllById1(Long id);
}
