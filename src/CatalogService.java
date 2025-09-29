import java.util.ArrayList;
import java.util.List;

public class CatalogService {
    private final List<Media> mediaItems = new ArrayList<>();

    public void addMedia(Media media) { mediaItems.add(media); }

    public void removeMedia(Media media) { mediaItems.remove(media); }
    public List<Media> listAll() { return new ArrayList<>(mediaItems); }

    public void viewMediaItems() {
        for (Media m : mediaItems) { m.printMediaDetails(); System.out.println(); }
    }

    public void viewBooks() {
        for (Media m : mediaItems) {
            if (m instanceof Book) { m.printMediaDetails(); System.out.println(); }
        }
    }

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
}
