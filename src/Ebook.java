public class Ebook extends Media {
    private String author;
    private EbookFormat ebookFormat;
    private double fileSizeMB;
    private boolean hasDRM;

    public Ebook(String title, double price, int yearPublished, String author, EbookFormat ebookFormat, double fileSizeMB, boolean hasDRM) {
        super(title, price, yearPublished);
        this.author = author;
        this.ebookFormat = ebookFormat;
        this.fileSizeMB = fileSizeMB;
        this.hasDRM = hasDRM;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public EbookFormat getEbookFormat() { return ebookFormat; }
    public void setEbookFormat(EbookFormat ebookFormat) { this.ebookFormat = ebookFormat; }

    public double getFileSizeMB() { return fileSizeMB; }
    public void setFileSizeMB(double fileSizeMB) { this.fileSizeMB = fileSizeMB; }

    public boolean hasDRM() { return hasDRM; }
    public void setDRM(boolean hasDRM) { this.hasDRM = hasDRM; }

    @Override
    public void printMediaDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year Published: " + yearPublished);
        System.out.println("Format: " + ebookFormat);
        System.out.println("File Size: " + fileSizeMB + " MB");
        System.out.println("DRM Protected: " + (hasDRM ? "Yes" : "No"));
        System.out.println("Price: $" + price);
    }

    @Override
    public String getMediaType() {
        return "Ebook";
    }

    public boolean isAuthorValid() { return author != null && !author.isEmpty(); }
    public boolean isFileSizeValid() { return fileSizeMB > 0; }
}
