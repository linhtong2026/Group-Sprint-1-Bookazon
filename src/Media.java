
public abstract class Media {

    protected String title;
    protected double price;
    protected int yearPublished;

    public Media(String title, double price, int yearPublished) {
        this.title = title;
        this.price = price;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public abstract void printMediaDetails();

    public abstract String getMediaType();

    public boolean isPriceValid() {
        return price > 0;
    }

    public boolean isTitleValid() {
        return title != null && !title.isEmpty();
    }

    public boolean isYearPublishedValid() {
        return yearPublished > 0;
    }
}
