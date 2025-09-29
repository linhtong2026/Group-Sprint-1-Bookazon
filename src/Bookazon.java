import java.util.ArrayList;

public class Bookazon {

    ArrayList<Media> mediaItems;
    ArrayList<User> users;

    public Bookazon() {
        mediaItems = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addMedia(Media media) { mediaItems.add(media); }
    public void addBook(Book book) { mediaItems.add(book); }
    public void addUser(User user) { users.add(user); }

    public void viewMediaItems() {
        for (Media media : mediaItems) {
            media.printMediaDetails();
            System.out.println();
        }
    }

    public void viewBooks() {
        for (Media media : mediaItems) {
            if (media instanceof Book) {
                media.printMediaDetails();
                System.out.println();
            }
        }
    }

    public void viewUsers() {
        for (User user : users) {
            System.out.println(user.getName() + " - Role: " + user.getSubscription());
        }
    }

    public void removeMedia(Media media) { mediaItems.remove(media); }
    public void removeBook(Book book) { mediaItems.remove(book); }
    public void removeUser(User user) { users.remove(user); }

    public void updateMediaDetails(Media media, String newTitle, int newYearPublished, double newPrice) {
        media.setTitle(newTitle);
        media.setYearPublished(newYearPublished);
        media.setPrice(newPrice);
    }

    public void updateBookDetails(Book book, String newTitle, String newAuthor,
                                  int newYearPublished, double newPrice, CoverType coverType) {
        updateMediaDetails(book, newTitle, newYearPublished, newPrice);
        book.setAuthor(newAuthor);
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
        
        bookazon.addMedia(new Audiobook("Gregor the Overlander", 14.99, 2003, "Suzanne Collins", 1140, AudioFormat.MP3));
        bookazon.addMedia(new DVD("The Matrix", 12.99, 1999, "The Wachowskis", 136, VideoFormat.BLU_RAY, "Sci-Fi"));
        bookazon.addMedia(new Ebook("One Man's View of the World", 9.99, 2013, "Kee Kuan Yew", EbookFormat.EPUB, 2.5, false));

        bookazon.addUser(new User("Alice", new SubscriptionNormal()));
        bookazon.addUser(new User("Bob", new SubscriptionGold()));

        System.out.println("=== All Media Items ===");
        bookazon.viewMediaItems();

        bookazon.users.get(0).addToCart((Book) bookazon.mediaItems.get(0), 1);
        bookazon.users.get(0).addToCart(bookazon.mediaItems.get(3), 1);
        bookazon.users.get(0).addToCart(bookazon.mediaItems.get(4), 1);

        bookazon.users.get(0).viewCart();

        bookazon.users.get(0).setShippingAddress(new Address("123 Main St", "", "Springfield", "IL", "62701", "USA"));
        bookazon.users.get(0).setBillingAddress(new Address("456 Elm St", "", "Springfield", "IL", "62702", "USA"));

        bookazon.users.get(0).checkout();
        bookazon.users.get(0).viewOrders();
    }
}
