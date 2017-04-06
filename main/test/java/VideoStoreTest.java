import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VideoStoreTest {

    private static final String NAME = "Customer name";
    private final Customer customer = new Customer(NAME);

    @Test
    public void testSingleNewReleaseStatement() {
        customer.addRental(new Rental(createNewRelease("The Cell"), 3));
        assertEquals(
            "Rental Record for " + NAME + "\n"
                + "\tThe Cell\t9.0\n"
                + "You owed 9.0\n"
                + "You earned 2 frequent renter points\n",
            customer.buildStatement());
    }

    @Test
    public void testDualNewReleaseStatement() {
        customer.addRental(new Rental(createNewRelease("The Cell"), 3));
        customer.addRental(new Rental(createNewRelease("The Tigger Movie"), 3));
        assertEquals(
            "Rental Record for " + NAME + "\n"
                + "\tThe Cell\t9.0\n"
                + "\tThe Tigger Movie\t9.0\n"
                + "You owed 18.0\n"
                + "You earned 4 frequent renter points\n",
            customer.buildStatement());
    }

    @Test
    public void testSingleChildrensStatement() {
        customer.addRental(new Rental(createChildrens("The Tigger Movie"), 3));
        assertEquals(
            "Rental Record for " + NAME + "\n"
                + "\tThe Tigger Movie\t1.5\n"
                + "You owed 1.5\n"
                + "You earned 1 frequent renter points\n",
            customer.buildStatement());
    }

    @Test
    public void testSingleLongRentChildrensStatement() {
        customer.addRental(new Rental(createChildrens("The Tigger Movie"), 5));
        assertEquals(
            "Rental Record for " + NAME + "\n"
                + "\tThe Tigger Movie\t4.5\n"
                + "You owed 4.5\n"
                + "You earned 1 frequent renter points\n",
            customer.buildStatement());
    }

    @Test
    public void testMultipleRegularStatement() {
        customer.addRental(new Rental(createRegular("Plan 9 from Outer Space"), 1));
        customer.addRental(new Rental(createRegular("8 1/2"), 2));
        customer.addRental(new Rental(createRegular("Eraserhead"), 3));

        assertEquals(
            "Rental Record for " + NAME + "\n"
                + "\tPlan 9 from Outer Space\t2.0\n"
                + "\t8 1/2\t2.0\n"
                + "\tEraserhead\t3.5\n"
                + "You owed 7.5\n"
                + "You earned 3 frequent renter points\n",
            customer.buildStatement());
    }

    @Test
    public void testMultipleTypeStatement() {
        customer.addRental(new Rental(createNewRelease("The Cell"), 3));
        customer.addRental(new Rental(createRegular("Plan 9 from Outer Space"), 1));
        customer.addRental(new Rental(createRegular("8 1/2"), 2));
        customer.addRental(new Rental(createChildrens("The Tigger Movie"), 5));

        assertEquals(
            "Rental Record for " + NAME + "\n"
                + "\tThe Cell\t9.0\n"
                + "\tPlan 9 from Outer Space\t2.0\n"
                + "\t8 1/2\t2.0\n"
                + "\tThe Tigger Movie\t4.5\n"
                + "You owed 17.5\n"
                + "You earned 5 frequent renter points\n",
            customer.buildStatement());
    }

    private Movie createNewRelease(String title) {
        return new NewReleaseMovie(title);
    }

    private Movie createChildrens(String title) {
        return new ChildrensMovie(title);
    }

    private Movie createRegular(String title) {
        return new RegularMovie(title);
    }

}