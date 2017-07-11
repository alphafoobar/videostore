package videostore.movie;

public class NewReleaseMovie extends Movie {

    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public int calculatePoints(int daysRented) {
        if (daysRented < 2) {
            return 1;
        }
        return 2;
    }

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented * 3;
    }
}
