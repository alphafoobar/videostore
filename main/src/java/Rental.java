
public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    int calculatePoints() {
        int points = 1;

        if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1) {
            points++;
        }
        return points;
    }

    double calculateAmountOwed() {
        double thisAmount = 0;

        // determines the amount for each line
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (getDaysRented() > 2) {
                    thisAmount += (getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (getDaysRented() > 3) {
                    thisAmount += (getDaysRented() - 3) * 1.5;
                }
                break;
        }

        return thisAmount;
    }

    String toSummary() {
        return getMovie().getTitle() + "\t" + calculateAmountOwed() + "\n";
    }
}