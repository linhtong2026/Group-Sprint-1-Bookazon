public class Bookazon {
    public static void main(String[] args) {
        CatalogService catalog = new CatalogService();
        UserService users = new UserService();
        CheckoutService checkout = new CheckoutService();

        catalog.addMedia(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 9.99, CoverType.PAPERBACK));
        catalog.addMedia(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 7.99, CoverType.HARDCOVER));
        catalog.addMedia(new Book("1984", "George Orwell", 1949, 8.99, CoverType.PAPERBACK));
        catalog.addMedia(new Audiobook("Gregor the Overlander", 14.99, 2003, "Suzanne Collins", 1140, AudioFormat.MP3));
        catalog.addMedia(new DVD("The Matrix", 12.99, 1999, "The Wachowskis", 136, VideoFormat.BLU_RAY, "Sci-Fi"));
        catalog.addMedia(new Ebook("One Man's View of the World", 9.99, 2013, "Kee Kuan Yew", EbookFormat.EPUB, 2.5, false));

        if (args.length > 0 && "--addBook".equalsIgnoreCase(args[0])) {
            if (args.length == 6) {
                String title = args[1];
                String author = args[2];
                try {
                    int year = Integer.parseInt(args[3]);
                    double price = Double.parseDouble(args[4]);
                    String cover = args[5].toLowerCase();
                    CoverType coverType = cover.startsWith("p") ? CoverType.PAPERBACK
                                                                : CoverType.HARDCOVER;
                    catalog.addBook(new Book(title, author, year, price, coverType));
                    System.out.println("[CLI] Added book: " + title + " (" + coverType + ")");
                } catch (NumberFormatException nfe) {
                    System.out.println("[CLI] Invalid number for year/price. Usage:");
                    printAddBookUsage();
                }
            } else {
                printAddBookUsage();
            }
        }

        User alice = new User("Alice", new SubscriptionNormal());
        User bob   = new User("Bob", new SubscriptionGold());
        users.addUser(alice);
        users.addUser(bob);

        System.out.println("=== All Media Items ===");
        catalog.viewMediaItems();

        checkout.addToCart(alice, catalog.listAll().get(0), 1);
        checkout.addToCart(alice, catalog.listAll().get(3), 1);
        checkout.addToCart(alice, catalog.listAll().get(4), 1);

        checkout.viewCart(alice);

        users.setShippingAddress(alice, new Address("123 Main St", "", "Springfield", "IL", "62701", "USA"));
        users.setBillingAddress(alice,  new Address("456 Elm St", "", "Springfield", "IL", "62702", "USA"));

        checkout.checkout(alice);
        checkout.viewOrders(alice);
    }

    private static void printAddBookUsage() {
        System.out.println("Usage:");
        System.out.println("  --addBook \"Title\" \"Author\" <year> <price> <paperback|hardcover>");
        System.out.println("Example:");
        System.out.println("  --addBook \"Clean Code\" \"Robert C. Martin\" 2008 29.99 paperback");
    }
}
