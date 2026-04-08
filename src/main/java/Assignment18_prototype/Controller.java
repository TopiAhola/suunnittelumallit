package Assignment18_prototype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {



    public List<Book> books;
    public List<Recommendation> recommendations;


    public Controller() {
        this.books = new ArrayList<>();
        this.recommendations = new ArrayList<>();

        Book Book1 = new Book("Auth1", "Book1", "Horror", new Date(2020,6,1) );
        Book Book2 = new Book("Auth2", "Book2", "Horror", new Date(1980, 12,3) );
        Book Book3 = new Book("Auth3", "Book3", "Children", new Date(2025,3,8) );


        this.books.addAll(List.of(Book1, Book2, Book3));
        this.recommendations.addAll(List.of(
                new Recommendation("For Children", "Children", List.of(Book1,Book3) ),
                new Recommendation("Horror", "Adults", List.of(Book1,Book2)),
                new Recommendation("All books", "Everybody", List.of(Book1,Book2,Book3) )
        ));

    }



    public List<Book> getBooks() {
        return books;
    }

    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        this.books.remove( book );
        System.out.println("Removed"+book.title);
    }

    public void removeRecommendation(Recommendation r){
        this.recommendations.remove(r);

    }

    public Recommendation cloneRecommendation(Recommendation r){
        return r.clone();
    }

    public void addRecommendation(Recommendation rec){
        if (rec != null) {
        this.recommendations.add(rec);
    }
    }

}
