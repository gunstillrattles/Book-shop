package kz.narxoz.springbootdemo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "book_name", nullable = false)
    private String bookName;
    @Column(name = "author_name", nullable = false)
    private String authorName;
    @Column(name = "price", nullable = false)
    private String price;
}