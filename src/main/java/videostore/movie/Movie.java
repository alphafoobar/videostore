package videostore.movie;

public abstract class Movie {

    private final String title;

    Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int calculatePoints(int daysRented);

    public abstract double calculateAmount(int daysRented);
}
