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
        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : rentals) {
            result += "\t" + rental.toSummary();
        }

        result += "You owed " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";
        return result;
    }

}