
public class DVD extends Media {

    private String director;
    private int runtimeMinutes;
    private VideoFormat videoFormat;
    private String genre;

    public DVD(String title, double price, int yearPublished, String director, int runtimeMinutes, VideoFormat videoFormat, String genre) {
        super(title, price, yearPublished);
        this.director = director;
        this.runtimeMinutes = runtimeMinutes;
        this.videoFormat = videoFormat;
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(int runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public VideoFormat getVideoFormat() {
        return videoFormat;
    }

    public void setVideoFormat(VideoFormat videoFormat) {
        this.videoFormat = videoFormat;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void printMediaDetails() {
        System.out.println("Title: " + title);
        System.out.println("Director: " + director);
        System.out.println("Year Published: " + yearPublished);
        System.out.println("Runtime: " + runtimeMinutes + " minutes");
        System.out.println("Genre: " + genre);
        System.out.println("Format: " + videoFormat);
        System.out.println("Price: $" + price);
    }

    @Override
    public String getMediaType() {
        return "DVD";
    }

    public boolean isDirectorValid() {
        return director != null && !director.isEmpty();
    }

    public boolean isRuntimeValid() {
        return runtimeMinutes > 0;
    }

    public boolean isGenreValid() {
        return genre != null && !genre.isEmpty();
    }
}
