package kz.narxoz.springbootdemo.repository;

import kz.narxoz.springbootdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
