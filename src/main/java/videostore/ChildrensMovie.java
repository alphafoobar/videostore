package videostore;

public class ChildrensMovie extends Movie {

    public ChildrensMovie(String title) {
        super(title);
    }

    @Override
    int calculatePoints(int daysRented) {
        return 1;
    }

    @Override
    double calculateAmount(int daysRented) {
        double thisAmount = 1.5;
        if (daysRented > 3) {
            thisAmount += (daysRented - 3) * 1.5;
        }
        return thisAmount;
    }
}
