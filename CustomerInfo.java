public class CustomerInfo {

    private String customerID;
    private String name;
    private int age;
    private String favoriteFood;
    private String favoriteDrink;

    public CustomerInfo(String customerID, String name, int age, String favoriteFood, String favoriteDrink) {
        this.customerID = customerID;
        this.name = name;
        this.age = age;
        this.favoriteFood = favoriteFood;
        this.favoriteDrink = favoriteDrink;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public String getFavoriteDrink() {
        return favoriteDrink;
    }
    public String toString() {
        return "Customer ID: " + customerID + ", Name: " + name + ", Age: " + age + ", Favorite Food: " + favoriteFood + ", Favorite Drink: " + favoriteDrink;
    }

}
