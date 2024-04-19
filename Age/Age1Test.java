public class Age1Test {

    public static void main(String args[]) {

        System.out.println("Your age is: ");

        Age1 ageS = new Age1();
        ageS.setAgeS("Eighteen");
        String s = ageS.getAgeS();
        System.out.println(s);

        Age1 ageInt = new Age1();
        ageInt.setAgeI(18);
        int i = ageInt.getAgeI();
        System.out.println(i);

        Age1 ageDoub = new Age1();
        ageDoub.setAgeD(18.0);
        double d = ageDoub.getAgeD();
        System.out.println(d);

    }
}
