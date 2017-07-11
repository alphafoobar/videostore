package videostore;

import videostore.movie.Movie;

class Rental {

    private Movie movie;
    private int points;
    private double amount;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        points = movie.calculatePoints(daysRented);
        amount = movie.calculateAmount(daysRented);
    }

    private Movie getMovie() {
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
