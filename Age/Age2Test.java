
public class Age2Test {

    public static void main(String[] args) {

        System.out.println("Your age is: ");

        Age2 age = new Age2();
        age.setAge("Eighteen");
        String stringValue = (String) age.getAge();
        System.out.println(stringValue);

        age.setAge(18);
        int intValue = (int) age.getAge();
        System.out.println(intValue);

        age.setAge(18.0);
        double doubleValue = (double) age.getAge();
        System.out.println(doubleValue);
    }
}