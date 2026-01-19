package com.bikkadit.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikkadit.entity.Book;

public interface BookDao extends JpaRepository<Book, Serializable> {

}
