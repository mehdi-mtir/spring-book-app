package com.bna.booksapp.dtos;

public class BookDto {
    private long id;
    private String title;
    private String author;
    private double price;
    private String cover;
    private String description;

    public BookDto(long id, String title, String author, double price, String cover, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.cover = cover;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
