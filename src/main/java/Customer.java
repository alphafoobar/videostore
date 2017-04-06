import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    private double totalAmount = 0;
    private int frequentRenterPoints = 0;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
        totalAmount += rental.calculateAmountOwed();
        frequentRenterPoints += rental.calculatePoints();
    }

    public String getName() {
        return name;
    }

    public double getAmountOwed() {
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public String buildStatement() {
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