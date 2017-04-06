package videostore;

public class Rental {

    private Movie movie;
    private int points;
    private double amount;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        points = movie.calculatePoints(daysRented);
        amount = movie.calculateAmount(daysRented);
    }

    public Movie getMovie() {
        return movie;
    }

    int calculatePoints() {
        return points;
    }

    double calculateAmountOwed() {
        return amount;
    }

    String buildSummary() {
        return getMovie().getTitle() + "\t" + amount + "\n";
    }
}
