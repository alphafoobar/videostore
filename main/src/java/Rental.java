
public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    int calculatePoints() {
        return movie.calculatePoints(daysRented);
    }

    double calculateAmountOwed() {
        return movie.calculateAmount(daysRented);
    }

    String toSummary() {
        return getMovie().getTitle() + "\t" + calculateAmountOwed() + "\n";
    }
}