public class Book extends Media {
    private String author;
    private CoverType coverType; 

    public Book(String title, String author, int yearPublished, double price, CoverType coverType) {
        super(title, price, yearPublished);
        this.author = author;
        this.coverType = coverType;
    }


    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public CoverType getCoverType() { return coverType; }
    public void setCoverType(CoverType coverType) { this.coverType = coverType; }

    @Override
    public void printMediaDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year Published: " + yearPublished);
        System.out.println("Price: $" + price);
        System.out.println("Cover: " + coverType); 
    }

    @Override
    public String getMediaType() {
        return "Book";
    }


    public boolean isAuthorValid() { return author != null && !author.isEmpty(); }
}
