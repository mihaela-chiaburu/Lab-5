package com.example.lab5.entity;

import java.util.Objects;

public class Book {
    private int bookId;
    private String title;
    private String isbn;
    private int publicationYear;
    private String genre;
    private int copiesAvailable;

    public Book(){
    }
    public Book(int bookId, String title, String isbn, int publicationYear, String genre, int copiesAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.copiesAvailable = copiesAvailable;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && publicationYear == book.publicationYear && copiesAvailable == book.copiesAvailable && Objects.equals(title, book.title) && Objects.equals(isbn, book.isbn) && Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, isbn, publicationYear, genre, copiesAvailable);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationYear=" + publicationYear +
                ", genre='" + genre + '\'' +
                ", copiesAvailable=" + copiesAvailable +
                '}';
    }
}
