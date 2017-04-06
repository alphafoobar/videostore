

abstract class Movie {

    private final String title;

    Movie(String title) {
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    abstract int calculatePoints(int daysRented);

    abstract double calculateAmount(int daysRented);
}