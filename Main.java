import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Library library = new Library();

    // Sample books
    library.addBook(new Book("Java Basics", "John Doe"));
    library.addBook(new Book("Data Structures", "Jane Smith"));
    library.addBook(new Book("OOP in Java", "Alan Turing"));

    User user = new User("Khushi", 101); // You can change this

    Scanner sc = new Scanner(System.in);
    int choice;

    do {
      System.out.println("\n--- Library Menu ---");
      System.out.println("1. Show All Books");
      System.out.println("2. Issue a Book");
      System.out.println("3. Return a Book");
      System.out.println("4. Exit");
      System.out.print("Enter your choice: ");
      choice = sc.nextInt();
      sc.nextLine(); // consume newline

      switch (choice) {
        case 1:
          library.showAllBooks();
          break;
        case 2:
          System.out.print("Enter book title to issue: ");
          String issueTitle = sc.nextLine();
          library.issueBook(issueTitle, user);
          break;
        case 3:
          System.out.print("Enter book title to return: ");
          String returnTitle = sc.nextLine();
          library.returnBook(returnTitle, user);
          break;
        case 4:
          System.out.println("Thank you for using the system.");
          break;
        default:
          System.out.println("Invalid choice.");
      }
    } while (choice != 4);

    sc.close();
  }
}
