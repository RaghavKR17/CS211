import java.util.Random;

public class NewRandom extends Random {

    // Returns a random integer between the specified 'low' and 'high' values.
    public int nextInt(int low, int high) {
        return low + nextInt(high - low + 1);
    }

    // Returns a random lowercase letter from 'a' to 'z'.
    public char nextChar() {
        return (char) ('a' + nextInt(26));
    }

    // Returns a random lowercase letter between the specified 'from' and 'to' characters.
    public char nextChar(char from, char to) {
        if (from < to) {
            int range = to - from + 1;
            return (char) (from + nextInt(range));
        } else if (from > to) {
            int range = ('z' - from) + (to - 'a') + 2;
            return (char) (((from - 'a') + nextInt(range)) % 26 + 'a');
        } else {
            return from;
        }
    }

    // Returns a random lowercase letter starting from the specified 'from' character and offset by 'i' positions.
    public char nextChar(char from, int i) {
        int range = 26; // Number of lowercase letters

        if (i > 0) {
            // Positive offset, use nextInt(i+1) to generate a random character within the range
            return (char) ((from - 'a' + nextInt(i + 1)) % range + 'a');
        } else if (i < 0) {
            // Negative offset, use nextInt(range) to generate a random character within the range
            return (char) ((from - 'a' - nextInt(-i + 1) + range) % range + 'a');
        } else {
            // i is zero, return the same character
            return from;
        }
    }
    // Returns a random special character.
    public char nextSpecialChar() {
        char x = ' ';
        boolean isSpecial = false;
        while(!isSpecial) {
            x = nextChar('!','~');
            if(!Character.isLetterOrDigit(x)){
                isSpecial = true;
            }
        }
        return x;
    }
}
