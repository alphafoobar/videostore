package videostore;

import java.util.ArrayList;
import java.util.List;

class Customer {

    private final List<Rental> rentals = new ArrayList<>();
    private final String name;

    private double totalAmount;
    private int frequentRenterPoints;

    Customer(String name) {
        this.name = name;
    }

    void addRental(Rental rental) {
        rentals.add(rental);
        totalAmount += rental.calculateAmountOwed();
        frequentRenterPoints += rental.calculatePoints();
    }

    private String getName() {
        return name;
    }

    double getAmountOwed() {
        return totalAmount;
    }

    int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    String buildStatement() {
        return buildHeader() + buildStatementBody() + buildFooter();
    }

    private String buildStatementBody() {
        StringBuilder statement = new StringBuilder(100);
        for (Rental rental : rentals) {
            statement.append('\t').append(rental.buildSummary());
        }
        return statement.toString();
    }

    private String buildHeader() {
        return "Rental Record for " + getName() + "\n";
    }

    private String buildFooter() {
        return "You owed " + totalAmount + "\n" +
            "You earned " + frequentRenterPoints + " frequent renter points\n";
    }

}
