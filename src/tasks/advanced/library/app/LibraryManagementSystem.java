package tasks.advanced.library.app;

import tasks.advanced.library.models.Book;
import tasks.advanced.library.models.User;
import tasks.advanced.library.service.LibraryService;

import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        LibraryService service = new LibraryService();
        Scanner scn = new Scanner(System.in);

        while (true){
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View All Books ");
            System.out.println("6. View All Users");
            System.out.println("7. View All Transactions");
            System.out.println("8. Exit");
            System.out.println("Choose an option: ");

            int choice = scn.nextInt();
            scn.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter Book Title: ");
                    String title = scn.nextLine();

                    System.out.println("Enter Author: ");
                    String author = scn.nextLine();

                    System.out.println("Enter Quantity: ");
                    int quantity = scn.nextInt();
                    scn.nextLine();

                    Book book = new Book(title, author, true);
                    book.setQuantity(quantity);
                    service.addBook(book);
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.println("Enter User Name: ");
                    String username = scn.nextLine();

                    System.out.println("Enter User Email: ");
                    String userEmail = scn.nextLine();

                    User user = new User(0, username, userEmail);
                    service.addUser(user);
                    break;

                case 3:
                    System.out.println("Enter User ID: ");
                    int borrowUserId = scn.nextInt();

                    System.out.println("Enter Book ID: ");
                    int borrowBookId = scn.nextInt();

                    service.borrowBook(borrowUserId, borrowBookId);
                    break;

                case 4:
                    System.out.println("Enter User ID for returning book: ");
                    int returnUserId = scn.nextInt();

                    System.out.println("Enter Book ID of returning book: ");
                    int returnBookId = scn.nextInt();

                    service.returnBook(returnUserId, returnBookId);
                    break;

                case 5:
                    List<Book> books = service.getAllBooks();
                    System.out.println("\n===== All Books =====");
                    books.forEach(b -> System.out.println(b.getId() + ". " + b.getTitle() + " - " + b.getAuthor() + "(Quantity: " + b.getQuantity() + ")"));
                    break;

                case 6:
                    List<User> users = service.getAllUsers();
                    System.out.println("\n===== All Users =====");
                    users.forEach(u -> System.out.println(u.getId() + ". " + u.getName()));
                    break;

                case 7:
                    var transactions = service.getAllTransactions();
                    System.out.println("\n===== All Transactions =====");
                    transactions.forEach(t -> {
                        System.out.println(t.getId() + ", User: " + t.getUserId()+ ", Book: " + t.getBookId()+ ", Type: " + t.getAction() + ", Date: " + t.getDate());
                    });
                    break;

                case 8:
                    System.out.println("Exiting... Goodbye!");
                    scn.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

    }
}
