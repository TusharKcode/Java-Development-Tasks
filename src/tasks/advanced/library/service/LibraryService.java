package tasks.advanced.library.service;

import tasks.advanced.library.dao.BookDAO;
import tasks.advanced.library.dao.TransactionDAO;
import tasks.advanced.library.models.Book;
import tasks.advanced.library.models.Transaction;
import tasks.advanced.library.models.User;
import tasks.advanced.library.dao.UserDAO;

import java.time.LocalDate;
import java.util.List;


public class LibraryService {

    private final BookDAO bookDAO;
    private final UserDAO userDAO;
    private final TransactionDAO transactionDAO;

    public LibraryService(){
        bookDAO = new BookDAO();
        userDAO = new UserDAO();
        transactionDAO = new TransactionDAO();
    }

    // add new book
    public void addBook(Book book){
        bookDAO.addBook(book);
    }

    // add new user
    public void addUser(User user){
        userDAO.addUser(user);
    }

    // Borrow a book
    public void borrowBook(int userId, int bookId){
        Book book = bookDAO.getBookById(bookId);

        if (book == null){
            System.out.println("Book not found!");
            return;
        }

        if (book.getQuantity() <= 0){
            System.out.println("Book not available!");
            return;
        }

        // Decrease quantity by 1
        int newQuantity = book.getQuantity() - 1;
        bookDAO.updateQuantity(bookId, newQuantity);

        // update availability
        if (newQuantity == 0){
            bookDAO.updateAvailability(bookId, false);
        }

        // add transaction
        Transaction t = new Transaction(userId, bookId, "Borrow", LocalDate.now());
        transactionDAO.addTransaction(t);

        System.out.println("Book borrowed successfully!");

    }

    // Return a book
    public void returnBook(int userId, int bookId){
        Book book = bookDAO.getBookById(bookId);

        if (book == null){
            System.out.println("Book not found!");
            return;
        }

        // Increase Quantity by 1
        int newQuantity = book.getQuantity() + 1;
        bookDAO.updateQuantity(bookId, newQuantity);

        // update availability
        if (!book.isAvailable()){
            bookDAO.updateAvailability(bookId, true);
        }

        // Add transaction
        Transaction t = new Transaction(userId, bookId, "Return", LocalDate.now());
        transactionDAO.addTransaction(t);

        System.out.println("Book borrowed successfully!");

    }

    // Displays all books
    public List<Book> getAllBooks(){
        return bookDAO.getAllBooks();
    }

    // Displays all users
    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }

    // Displays all transactions
    public List<Transaction> getAllTransactions(){
        return transactionDAO.getAllTransactions();
    }
}
