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

    public void updateMediaDetails(Media media, String newTitle, int newYearPublished, double newPrice) {
        media.setTitle(newTitle);
        media.setYearPublished(newYearPublished);
        media.setPrice(newPrice);
    }
}
