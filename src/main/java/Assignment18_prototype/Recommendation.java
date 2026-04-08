package Assignment18_prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Recommendation {
    public String name;
    public String targetAudience;
    public List<Book> books;


    public Recommendation(String name, String targetAudience, List<Book> books) {
        this.name = name;
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>(books);
    }


   public Recommendation clone(){
        return new Recommendation(
                "Clone of: " +this.name,
                this.targetAudience,
                this.books.stream().collect(Collectors.toCollection(ArrayList::new))
        );

   }

   public void addBook(Book book){
        this.books.add(book);

   }

   public void removeBook(String title){
      this.books.removeIf( book -> book.title.equals(title) );
   }


    public String getTargetAudience() {
        return targetAudience != null ? targetAudience : "target audience";
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }
}
