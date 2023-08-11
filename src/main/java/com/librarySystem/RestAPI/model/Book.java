package com.librarySystem.RestAPI.model;



import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Books")
@Getter
@Setter
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Column(name = "title", unique = true)
	private String title;

	@NotNull
	@Column(name = "author")
	private String author;

	@NotNull
	@Column(name = "stock")
	private int stock;


	public Book() {

	}

	public Book(String title, String author, int stock, Date borrowedDate, Date returnedDate) {
		this.title = title;
		this.author = author;
		this.stock = stock;
	}

}
