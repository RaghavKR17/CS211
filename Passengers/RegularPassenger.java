// Subclass for regular passengers
public class RegularPassenger extends BusFare {
    // Override method to get and update regular fare
    double getFare() {
        // Regular fare remains the same for regular passengers
        return super.getFare();
    }

    // Override method to get and update regular color
    String getColor() {
        // Regular color remains the same for regular passengers
        return super.getColor();
    }

    // Method to print bus ticket
    void printTicket() {
        System.out.println("Fare: " + getFare() + " Color: " + getColor());
    }
}
