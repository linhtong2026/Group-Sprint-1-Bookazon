import java.util.ArrayList;

public class Bookazon {

    ArrayList<Book> books;
    ArrayList<User> users;

    public Bookazon() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) { books.add(book); }
    public void addUser(User user) { users.add(user); }

    public void viewBooks() {
        for (Book book : books) {
            book.printBookDetails();
        }
    }

    public void viewUsers() {
        for (User user : users) {
            System.out.println(user.getName() + " - Role: " + user.getSubscription());
        }
    }

    public void removeBook(Book book) { books.remove(book); }
    public void removeUser(User user) { users.remove(user); }

    public void updateBookDetails(Book book, String newTitle, String newAuthor,
                                  int newYearPublished, double newPrice, CoverType coverType) {
        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
        book.setYearPublished(newYearPublished);
        book.setPrice(newPrice);
        book.setCoverType(coverType);
    }

    public void updateBookDetails(Book book, String newTitle, String newAuthor,
                                  int newYearPublished, double newPrice, boolean isPaperback) {
        updateBookDetails(book, newTitle, newAuthor, newYearPublished, newPrice,
                isPaperback ? CoverType.PAPERBACK : CoverType.HARDCOVER);
    }

    public void updateRole(User user, Subscription subscription) { user.setSubscription(subscription); }

    public static void main(String[] args) {
        Bookazon bookazon = new Bookazon();

        bookazon.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 9.99, true));
        bookazon.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 7.99, false));
        bookazon.addBook(new Book("1984", "George Orwell", 1949, 8.99, true));

        bookazon.addUser(new User("Alice", new SubscriptionNormal()));
        bookazon.addUser(new User("Bob", new SubscriptionGold()));

        bookazon.users.get(0).addToCart(bookazon.books.get(0), 1);
        bookazon.users.get(0).addToCart(bookazon.books.get(1), 2);

        bookazon.users.get(0).viewCart();


        // set shipping address and billing address
        bookazon.users.get(0).setShippingAddress(new Address("123 Main St", "", "Springfield", "IL", "62701", "USA"));
        bookazon.users.get(0).setBillingAddress(new Address("456 Elm St", "", "Springfield", "IL", "62702", "USA"));

        bookazon.users.get(0).checkout();
        bookazon.users.get(0).viewOrders();
    }
}
