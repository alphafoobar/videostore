package videostore.movie;

public class ChildrensMovie extends Movie {

    public ChildrensMovie(String title) {
        super(title);
    }

    @Override
    public int calculatePoints(int daysRented) {
        return 1;
    }

    @Override
    public double calculateAmount(int daysRented) {
        double thisAmount = 1.5;
        if (daysRented > 3) {
            thisAmount += (daysRented - 3) * 1.5;
        }
        return thisAmount;
    }
}
