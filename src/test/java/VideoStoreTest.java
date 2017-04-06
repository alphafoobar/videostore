import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class VideoStoreTest {

    private static final String NAME = "Customer name";
    private static final String NEW_RELEASE_TITLE = "New Release Title";
    private static final String REGULAR_TITLE = "Regular title";
    private static final String CHILDREN_S_TITLE = "Children's title";
    private final Customer customer = new Customer(NAME);

    @Test
    public void testZeroStatement() {
        assertEquals(0, customer.getAmountOwed(), 0.0001);
        assertThat(customer.getFrequentRenterPoints(), equalTo(0));

        assertEquals(
            "Rental Record for " + NAME + "\n"
                + "You owed 0.0\n"
                + "You earned 0 frequent renter points\n",
            customer.buildStatement());
    }

    @Test
    public void testMultipleTypeStatement() {
        customer.addRental(new Rental(createNewRelease(), 3));
        customer.addRental(new Rental(createRegular(), 1));
        customer.addRental(new Rental(createRegular(), 2));
        customer.addRental(new Rental(createChildrens(), 5));

        double expectedAmount = 17.5;
        int expectedPoints = 5;
        assertEquals(expectedAmount, customer.getAmountOwed(), 0.0001);
        assertThat(customer.getFrequentRenterPoints(), equalTo(expectedPoints));

        assertEquals(
            "Rental Record for " + NAME + "\n"
                + "\t" + NEW_RELEASE_TITLE + "\t9.0\n"
                + "\t" + REGULAR_TITLE + "\t2.0\n"
                + "\t" + REGULAR_TITLE + "\t2.0\n"
                + "\t" + CHILDREN_S_TITLE + "\t4.5\n"
                + "You owed " + expectedAmount + "\n"
                + "You earned " + expectedPoints + " frequent renter points\n",
            customer.buildStatement());
    }

    @Test
    public void testSingleDayNewReleaseStatement() {
        customer.addRental(new Rental(createNewRelease(), 1));

        assertEquals(3, customer.getAmountOwed(), 0.0001);
        assertThat(customer.getFrequentRenterPoints(), equalTo(1));
    }

    @Test
    public void testSingleNewReleaseStatement() {
        customer.addRental(new Rental(createNewRelease(), 3));

        assertEquals(9, customer.getAmountOwed(), 0.0001);
        assertThat(customer.getFrequentRenterPoints(), equalTo(2));
    }

    @Test
    public void testDualNewReleaseStatement() {
        customer.addRental(new Rental(createNewRelease(), 3));
        customer.addRental(new Rental(createNewRelease(), 3));

        assertEquals(18, customer.getAmountOwed(), 0.0001);
        assertThat(customer.getFrequentRenterPoints(), equalTo(4));
    }

    @Test
    public void testSingleChildrensStatement() {
        customer.addRental(new Rental(createChildrens(), 3));

        assertEquals(1.5, customer.getAmountOwed(), 0.0001);
        assertThat(customer.getFrequentRenterPoints(), equalTo(1));
    }

    @Test
    public void testSingleLongRentChildrensStatement() {
        customer.addRental(new Rental(createChildrens(), 5));

        assertEquals(4.5, customer.getAmountOwed(), 0.0001);
        assertThat(customer.getFrequentRenterPoints(), equalTo(1));
    }

    @Test
    public void testMultipleRegularStatement() {
        customer.addRental(new Rental(createRegular(), 1));
        customer.addRental(new Rental(createRegular(), 2));
        customer.addRental(new Rental(createRegular(), 3));

        assertEquals(7.5, customer.getAmountOwed(), 0.0001);
        assertThat(customer.getFrequentRenterPoints(), equalTo(3));
    }

    private Movie createNewRelease() {
        return new NewReleaseMovie(NEW_RELEASE_TITLE);
    }

    private Movie createChildrens() {
        return new ChildrensMovie(CHILDREN_S_TITLE);
    }

    private Movie createRegular() {
        return new RegularMovie(REGULAR_TITLE);
    }

}
