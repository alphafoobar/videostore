

public abstract class Movie {

    private final String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    abstract int calculatePoints(int daysRented);

    abstract double calculateAmount(int daysRented);
}