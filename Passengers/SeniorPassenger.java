// Subclass for senior passengers
public class SeniorPassenger extends BusFare {
    // Override method to get and update senior fare
    double getFare() {
        // Senior passengers get a 50% discount
        return super.getFare() * 0.5;
    }

    // Override method to get and update senior color
    String getColor() {
        // Senior ticket color is grey
        return "Grey";
    }

    // Method to print bus ticket
    void printTicket() {
        System.out.println("Fare: " + getFare() + " Color: " + getColor());
    }
}
