package com.example.BookStoreVermeg.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

@Entity
@Table(name ="Book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Author")
	@NotNull(message = "The name of the author can not be empty")
	@Size(min=4, message = "the author's " + "length must be at least 4")
	private String author;
	@Column(name="Title")
	@NotNull(message = "The title can not be empty")
	//@Size(min=4, message = "the title's " + "length must be at least 4")
	private String title;
	@NotNull(message = "The price can't be empty")
	//@Positive(message = "The price must be more " +
            "then 0")
    private double price;
    @Nullable
    private Date releaseDate;

    public Book(String title, String author, double price,  Date releaseDate) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public Book(Long id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + ", price=" + price + ", releaseDate="
				+ releaseDate + "]";
	}
}
	
	
	


