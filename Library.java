import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
  private List<Book> books;
  private Map<Integer, List<Book>> issuedBooks;

  public Library() {
    books = new ArrayList<>();
    issuedBooks = new HashMap<>();
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public void showAllBooks() {
    System.out.println("\nBooks in Library:");
    for (Book b : books) {
      System.out.println(b);
    }
  }

  public void issueBook(String title, User user) {
    for (Book b : books) {
      if (b.getTitle().equalsIgnoreCase(title) && !b.isIssued()) {
        b.issue();
        issuedBooks.computeIfAbsent(user.getUserId(), k -> new ArrayList<>()).add(b);
        System.out.println("Book issued to " + user.getName());
        return;
      }
    }
    System.out.println("Book not available or already issued.");
  }

  public void returnBook(String title, User user) {
    List<Book> userBooks = issuedBooks.get(user.getUserId());
    if (userBooks != null) {
      for (Book b : userBooks) {
        if (b.getTitle().equalsIgnoreCase(title)) {
          b.returnBook();
          userBooks.remove(b);
          System.out.println("Book returned successfully.");
          return;
        }
      }
    }
    System.out.println("Book not found for this user.");
  }
}
