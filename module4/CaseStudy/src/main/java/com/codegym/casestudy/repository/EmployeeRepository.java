package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
//    List<Employee> findAllByEmployee_nameContaining(String Name);
@Query(value = "select * from employee where employee_name like ?", nativeQuery = true)
List<Employee> querySubjectByTeacherName(String teacher);
}
