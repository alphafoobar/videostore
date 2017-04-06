public class NewReleaseMovie extends Movie {

    public NewReleaseMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    int calculatePoints(int daysRented) {
        if (daysRented < 2) {
            return 1;
        }
        return 2;
    }

    @Override
    double calculateAmount(int daysRented) {
        return daysRented * 3;
    }
}
