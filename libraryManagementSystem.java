import java.util.*;

// Book Class
class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void issue() { isIssued = true; }
    public void returnBook() { isIssued = false; }

    public String toString() {
        return "[" + id + "] " + title + " by " + author + (isIssued ? " (Issued)" : " (Available)");
    }
}

// User Class
class User {
    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }

    public String toString() {
        return "[" + userId + "] " + name;
    }
}

// Library Class
class Library {
    private List<Book> books = new ArrayList<>();
    private Map<Integer, User> users = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(int bookId, int userId) {
        Optional<Book> bookOpt = books.stream().filter(b -> b.getId() == bookId).findFirst();
        if (!bookOpt.isPresent()) {
            System.out.println("Book not found.");
            return;
        }

        Book book = bookOpt.get();
        if (book.isIssued()) {
            System.out.println("Book already issued.");
        } else {
            if (users.containsKey(userId)) {
                book.issue();
                System.out.println("Book issued to " + users.get(userId).getName());
            } else {
                System.out.println("User not found.");
            }
        }
    }

    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (book.isIssued()) {
                    book.returnBook();
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book is not currently issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

// Main Class
public class libraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Preload books and users
        library.addBook(new Book(1, "1984", "George Orwell"));
        library.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        library.addUser(new User(101, "Alice"));
        library.addUser(new User(102, "Bob"));

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Display Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ID to issue: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    library.issueBook(bookId, userId);
                    break;
                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
