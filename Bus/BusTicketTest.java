/*
* Returns a random lowercase letter between the specified 'from' character and 'from + i' with looping.
* This implementation optimizes efficiency by using the nextInt() method strategically:
* - For positive offsets, it efficiently generates a character within the specified range.
* - For negative offsets, it cleverly utilizes nextInt(-i + 1) to achieve a backward looping effect without unnecessary calculations.
* When the offset is zero, the method returns the same character, maintaining simplicity.
*/

// Main test program
public class BusTicketTest {
    public static void main(String[] args) {
        // Create an object for senior passenger Ted
        SeniorPassenger ted = new SeniorPassenger();
        // Call the method to print Ted's ticket
        ted.printTicket();

        // Create an object for regular passenger Chloe
        RegularPassenger chloe = new RegularPassenger();
        // Call the method to print Chloe's ticket
        chloe.printTicket();
    }
}
