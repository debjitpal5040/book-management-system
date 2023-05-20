package com.debjit.pal.bookmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.debjit.pal.bookmanagementsystem.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{

	@Modifying
	@Query(value = "ALTER TABLE books AUTO_INCREMENT = 1;", nativeQuery = true)
	public void resetAutoIncrement();
	
}
