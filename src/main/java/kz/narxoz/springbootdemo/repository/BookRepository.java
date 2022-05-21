package kz.narxoz.springbootdemo.repository;

import kz.narxoz.springbootdemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
