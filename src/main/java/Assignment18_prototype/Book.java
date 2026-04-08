package Assignment18_prototype;

import java.util.Date;

public class Book {
    String author;
    String title;
    String genre;
    Date published;


    public Book(String author, String title, String genre, Date published) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.published = published;
    }


    public String getAuthor() {
        return author != null ? author : "author";
    }

    public String getTitle() {
        return title != null ? title : "title";
    }

    public String getGenre() {
        return genre != null ? genre : "title";    }

    public Date getPublished() {
        return published != null ? published : new Date();    }
}
