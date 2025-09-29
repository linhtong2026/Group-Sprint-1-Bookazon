public class Book {
    private String title;
    private String author;
    private int yearPublished;
    private double price;
    private CoverType coverType; 

    public Book(String title, String author, int yearPublished, double price, CoverType coverType) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
        this.coverType = coverType;
    }

    public Book(String title, String author, int yearPublished, double price, boolean isPaperback) {
        this(title, author, yearPublished, price,
             isPaperback ? CoverType.PAPERBACK : CoverType.HARDCOVER);
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getYearPublished() { return yearPublished; }
    public void setYearPublished(int yearPublished) { this.yearPublished = yearPublished; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public CoverType getCoverType() { return coverType; }
    public void setCoverType(CoverType coverType) { this.coverType = coverType; }

    public boolean isPaperback() { return coverType == CoverType.PAPERBACK; }

    public void setPaperback(boolean isPaperback) {
        this.coverType = isPaperback ? CoverType.PAPERBACK : CoverType.HARDCOVER;
    }

    public void printBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year Published: " + yearPublished);
        System.out.println("Price: $" + price);
        System.out.println("Cover: " + coverType); 
    }

    public boolean isPriceValid() { return price > 0; }
    public boolean isTitleValid() { return title != null && !title.isEmpty(); }
    public boolean isAuthorValid() { return author != null && !author.isEmpty(); }
    public boolean isYearPublishedValid() { return yearPublished > 0; }
}
