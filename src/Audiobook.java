
public class Audiobook extends Media {

    private String narrator;
    private int durationMinutes;
    private AudioFormat audioFormat;

    public Audiobook(String title, double price, int yearPublished, String narrator, int durationMinutes, AudioFormat audioFormat) {
        super(title, price, yearPublished);
        this.narrator = narrator;
        this.durationMinutes = durationMinutes;
        this.audioFormat = audioFormat;
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public AudioFormat getAudioFormat() {
        return audioFormat;
    }

    public void setAudioFormat(AudioFormat audioFormat) {
        this.audioFormat = audioFormat;
    }

    @Override
    public void printMediaDetails() {
        System.out.println("Title: " + title);
        System.out.println("Narrator: " + narrator);
        System.out.println("Year Published: " + yearPublished);
        System.out.println("Duration: " + durationMinutes + " minutes");
        System.out.println("Format: " + audioFormat);
        System.out.println("Price: $" + price);
    }

    @Override
    public String getMediaType() {
        return "Audiobook";
    }

    public boolean isNarratorValid() {
        return narrator != null && !narrator.isEmpty();
    }

    public boolean isDurationValid() {
        return durationMinutes > 0;
    }
}
