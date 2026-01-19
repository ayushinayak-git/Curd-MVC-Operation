package com.bikkadit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="booksStock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
@Id
private int bid;
private String bname;
private String author;
private double price;
private String status;

}
