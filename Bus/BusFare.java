// Superclass representing common properties of bus fare
public class BusFare {
    private double regularFare = 5.0;  // Regular fare amount
    private String regularColor = "Red";  // Regular ticket color

    // Getter method for regular fare
    double getFare() {
        return regularFare;
    }

    // Getter method for regular color
    String getColor() {
        return regularColor;
    }
}
